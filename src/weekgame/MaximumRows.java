package weekgame;

/**
 * @author chengj
 * @Description 2397.被列覆盖的最多行数 中等
 * 第 86 场双周赛 第 3 题
 * @Date 2022/9/6
 */
//给你一个下标从 0 开始的 m x n 二进制矩阵 mat 和一个整数 cols ，表示你需要选出的列数。
//
// 如果一行中，所有的 1 都被你选中的列所覆盖，那么我们称这一行 被覆盖 了。
//
// 请你返回在选择 cols 列的情况下，被覆盖 的行数 最大 为多少。
//
//
//
// 示例 1：
//
//
//
// 输入：mat = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], cols = 2
//输出：3
//解释：
//如上图所示，覆盖 3 行的一种可行办法是选择第 0 和第 2 列。
//可以看出，不存在大于 3 行被覆盖的方案，所以我们返回 3 。
//
//
// 示例 2：
//
//
//
// 输入：mat = [[1],[0]], cols = 1
//输出：2
//解释：
//选择唯一的一列，两行都被覆盖了，原因是整个矩阵都被覆盖了。
//所以我们返回 2 。
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 12
// mat[i][j] 要么是 0 要么是 1 。
// 1 <= cols <= n
//
// 👍 12 👎 0
public class MaximumRows {

    public static void main(String[] args) {
        MaximumRows mr = new MaximumRows();
        int[][] mat = new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,0,1}};
        System.out.println(mr.maximumRows(mat,2));
        System.out.println(1 << 3);
    }

    public int maximumRows(int[][] matrix, int numSelect) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 把每行变成(反向)二进制并存储在mask 数组中
        // 这里二进制正向还是反向无所谓
        int[] mask = new int[n];
        for(int i = 0;i < n;i++){
            for(int j = m-1;j >= 0;j--){
                // matrix[i][j] 左移
                mask[i] += (matrix[i][j] << m-1 -j);
            }
        }
        int ans = 0;
        //这里是1左移m 那么多位，表示 2的m次方，表示 m个位置的空格可以填 1 或者 0
        for(int i = 0;i <(1 << m);i++){
            // 如果 i 在二进制中 1 的个数 和 numsSelect不同则不考虑
            if(Integer.bitCount(i) != numSelect){
                continue;
            }
            int cnt = 0;
            for(int j = 0; j < n;j++){
                // 把每行的二进制数拿出来和 i 做与运算
                // 如果还是和原来一样，则说明行可以覆盖
                if((mask[j] & i) == mask[j]){
                    cnt++;
                }
            }
            // 取 满足i 在二进制中 1 的个数 和 numsSelect相同时 ,可以覆盖的最大值
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}
