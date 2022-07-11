package graph;

/**
 * @author chengj
 * @Description 1020.飞地的数量 中等
 * @Date 2022/7/8
 */
//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//
//
// 示例 2：
//
//
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid[i][j] 的值为 0 或 1
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 178 👎 0
public class NumEnclaves {

    // 思路
    // 1、先把四周，边缘为陆地的开始往里查找，并且修改为0.
    // 2、然后遍历整个grid统计为1的数量即可
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for(int j = 0; j < n; j++){
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    result++;
                }
            }
        }
        return result;
    }
    private void dfs(int[][] grid, int x, int y){
        int m = grid.length;
        int n = grid[0].length;
        if(!inArea(m,n,x,y)){
            return;
        }
        if (grid[x][y] == 0){
            return;
        }
        grid[x][y] = 0;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    private boolean  inArea(int m,int n,int row,int col){
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}
