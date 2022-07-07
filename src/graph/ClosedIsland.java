package graph;

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

}
