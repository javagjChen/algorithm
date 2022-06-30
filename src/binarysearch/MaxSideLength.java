package binarysearch;

/**
 * @author chengj
 * @Description 1292.元素和小于等于阈值的正方形的最大边长 中等
 * @Date 2022/6/28
 */
//给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
//
// 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
//
//
// 示例 1：
//
//
//
//
//输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
//输出：2
//解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
//
//
// 示例 2：
//
//
//输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]],
//threshold = 1
//输出：0
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 300
// 0 <= mat[i][j] <= 10⁴
// 0 <= threshold <= 10⁵
//
// Related Topics 数组 二分查找 矩阵 前缀和 👍 94 👎 0
public class MaxSideLength {

    public static void main(String[] args) {
        MaxSideLength msl = new MaxSideLength();
        int[][] mat = new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        int threshold = 0;
        System.out.println(msl.maxSideLength(mat,threshold));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] preSum = new int[n+1][m+1];

        for (int i = 1; i <= n;i++){
            for (int j = 1;j <= m;j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + mat[i-1][j-1];
            }
        }

        // 开始二分查找
        int l = 0;
        int r = Math.min(n,m) + 1;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            boolean flag = false;
            for (int i = 1; i <= n- mid + 1; ++i) {
                for (int j = 1; j <= m - mid + 1; ++j) {
                    if (getRectSum(preSum, i, j, i + mid - 1, j + mid - 1) <= threshold) {
                        flag = true;
                    }
//                    int temp = preSum[i + mid - 1][j + mid - 1] - preSum[i + mid - 1][j - 1] - preSum[i - 1][j + mid - 1] + preSum[i - 1][j - 1];
//                    if (temp <= threshold) {
//                        flag = true;
//                    }
                }
            }
            if (flag) {
                l = mid;
            } else {
                r = mid;
            }

        }

        return l;
    }

    private int getRectSum(int[][] preSum, int x1, int y1, int x2, int y2) {
        return preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1];

    }
}
