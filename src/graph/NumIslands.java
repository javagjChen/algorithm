package graph;

/**
 * @author chengj
 * @Description 200.岛屿数量 中等
 * @Date 2022/7/7
 */
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1785 👎 0
public class NumIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int row  = 0;row < m;row++){
            for (int col = 0; col < n;col++){
                if (grid[row][col] == '1'){
                    count++;
                    dps(grid,row,col);
                }
            }
        }
        return count;
    }

    private void dps(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if(!inArea(m,n,row,col)){
            return;
        }

        if(grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        dps(grid,row - 1,col);
        dps(grid,row + 1,col);
        dps(grid,row,col - 1);
        dps(grid,row,col + 1);
    }

    private boolean  inArea(int m,int n,int row,int col){
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}
