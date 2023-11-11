package graph;

import sun.text.normalizer.UTF16;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_16;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author chengj
 * @Description 1254.统计封闭岛屿的数目 中等
 * @Date 2022/7/7
 */
//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
//
// 请返回 封闭岛屿 的数目。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
//
// 示例 2：
//
//
//
//
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
//
//
// 示例 3：
//
//
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= grid.length, grid[0].length <= 100
// 0 <= grid[i][j] <=1
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 145 👎 0
public class ClosedIsland {

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int row  = 0;row < m;row++){
            for (int col = 0; col < n;col++){


                if (grid[row][col] == 0 && dps(grid,row,col)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dps(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;


        if(!inArea(m,n,row,col)){
            return false;
        }

        if(grid[row][col] == 1){
            return true;
        }

        grid[row][col] = 1;

        return dps(grid,row - 1,col) &
        dps(grid,row + 1,col) &
        dps(grid,row,col - 1) &
        dps(grid,row,col + 1);
    }

    private boolean  inArea(int m,int n,int row,int col){
        return 0 <= row && row < m && 0 <= col && col < n;
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException,
            InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException,
            SignatureException {
        // 替换为您的实际 PKCS #8 格式的私钥
        String privateKeyString = "MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQgcqCcJot/FvgBK1fw" +
                "3jNlJO0BUd3QoTqugBYxWNN4x6agCgYIKoZIzj0DAQehRANCAASgwgdih7ByYkPt" +
                "4JXkdSI5Aco9O5ryKX3dQAWSL+CZiEkwRgmG25e5vwxfOpwTjC5sIWy0tGRCAXRZ" +
                "pjQpK5/C";

        // 替换为您要签名的 UTF-8 字符串
        String utf8String = "com.black.bestwidgets\u20632HQ6U7UJ86\u2063com.black.bestwidgets.oneYear\u2063com.black.bestwidgets.year.free7a\u2063831313\u206397d8e55d-408b-41b5-9812-52cce119ab86\u20631678692539000";

        // 将 UTF-8 字符串转换为字节数组
        byte[] utf8Bytes = utf8String.getBytes(UTF_8);

        // 计算字节数组的 SHA-256 哈希值
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = sha256.digest(utf8Bytes);

        // 将 PKCS #8 格式的私钥字符串转换为字节数组
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);

        // 从字节数组生成私钥对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ECPrivateKey privateKey = (ECPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);

        // 创建 Signature 对象，使用 ECDSA 和 SHA-256 签名算法
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKey);

        // 对哈希值进行签名
        signature.update(hashBytes);
        byte[] signatureBytes = signature.sign();

        // 将签名转换为 Base64 编码字符串
        String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);

        // 打印签名结果
        System.out.println(new String(signatureBytes,UTF_8));
        System.out.println("Signature: " + signatureBase64);

    }
}
