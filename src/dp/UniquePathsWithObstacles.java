package dp;

/**
 * @author chengj
 * @Description 63.不同路径2 中等
 * @Date 2022/4/1
 */
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//
//
// 示例 1：
//
//
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
//
// 示例 2：
//
//
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] 为 0 或 1
//
// Related Topics 数组 动态规划 矩阵 👍 758 👎 0
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int i =0;i < m;i++){
            dp[i][0] = 1;
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;
            }
        }
        for(int i =0;i < n;i++){
            dp[0][i] = 1;
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }
        }

        for(int i = 1;i < m;i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i] [j - 1] + dp[i-1][j] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }
}
