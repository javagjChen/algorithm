package graph;

/**
 * @author chengj
 * @Description 695.岛屿的最大面积 中等
 * @Date 2022/7/7
 */
//给你一个大小为 m x n 的二进制矩阵 grid 。
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。
//
// 岛屿的面积是岛上值为 1 的单元格的数目。
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
//
//
// 示例 2：
//
//
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] 为 0 或 1
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 809 👎 0
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int row  = 0;row < m;row++){
            for (int col = 0; col < n;col++){
                if (grid[row][col] == 1){
                    ans = Math.max(ans,dps(grid,row,col));
                }
            }
        }
        return ans;
    }

    private int dps(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if(!inArea(m,n,row,col)){
            return 0;
        }

        if(grid[row][col] == 0){
            return 0 ;
        }

        grid[row][col] = 0;

        return 1 +
                dps(grid,row - 1,col) +
                dps(grid,row + 1,col) +
                dps(grid,row,col - 1) +
                dps(grid,row,col + 1);
    }

    private boolean  inArea(int m,int n,int row,int col){
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}
