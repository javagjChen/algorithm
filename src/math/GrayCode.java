package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 格雷编码 中等
 * @Author chengj
 * @Date 2022/1/27
 */

//n 位格雷码序列 是一个由 2ⁿ 个整数组成的序列，其中：
//
// 每个整数都在范围 [0, 2ⁿ - 1] 内（含 0 和 2ⁿ - 1）
// 第一个整数是 0
// 一个整数在序列中出现 不超过一次
// 每对 相邻 整数的二进制表示 恰好一位不同 ，且
// 第一个 和 最后一个 整数的二进制表示 恰好一位不同
//
//
// 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：[0,1,3,2]
//解释：
//[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
//- 00 和 01 有一位不同
//- 01 和 11 有一位不同
//- 11 和 10 有一位不同
//- 10 和 00 有一位不同
//[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
//- 00 和 10 有一位不同
//- 10 和 11 有一位不同
//- 11 和 01 有一位不同
//- 01 和 00 有一位不同
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 16
//
// Related Topics 位运算 数学 回溯 👍 468 👎 0
public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // 先将0加入
        result.add(0);
        if(n == 0){
            return result;
        }
        // 由于最高位前默认为 0 所以只需将当前result 按照倒叙输出并在每一个二进制前面加first即可
        int first = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--)
                result.add(first + result.get(j));
            // 左移一位
            first = first << 1;
        }
        return result;

    }

    public static List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i =0;i < 1<<n;i++){
            result.add(i ^ (i>>1));
        }
        return result;
    }
}
