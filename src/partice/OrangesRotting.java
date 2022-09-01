package partice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description 994.腐烂的橘子 中等
 * @Date 2022/8/30
 */
//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
//
//
// 值 0 代表空单元格；
// 值 1 代表新鲜橘子；
// 值 2 代表腐烂的橘子。
//
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
//
//
// 示例 2：
//
//
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
//
//
// 示例 3：
//
//
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] 仅为 0、1 或 2
//
// Related Topics 广度优先搜索 数组 矩阵 👍 590 👎 0
public class OrangesRotting {
    public static void main(String[] args) {
        OrangesRotting or = new OrangesRotting();
        //int[][] grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = new int[][]{{0,2}};
        System.out.println(or.orangesRotting(grid));
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 好橘子的数量
        int goodCount = 0;
        boolean flag = false;
        //
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1){
                    goodCount++;
                    flag = true;
                }
                if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size;i++){
                int[] tmp = queue.poll();
                //上
                if (tmp[0] >0 && grid[tmp[0] - 1][tmp[1]] == 1){
                    queue.add(new int[]{tmp[0]-1,tmp[1]});
                    grid[tmp[0] - 1][tmp[1]] =2;
                    goodCount--;
                }
                //下
                if (tmp[0] < m -1 && grid[tmp[0] + 1][tmp[1]] == 1){
                    queue.add(new int[]{tmp[0]+1,tmp[1]});
                    grid[tmp[0] + 1][tmp[1]] =2;
                    goodCount--;
                }
                //左
                if (tmp[1] > 0 && grid[tmp[0]][tmp[1] -1] == 1){
                    queue.add(new int[]{tmp[0],tmp[1] -1});
                    grid[tmp[0]][tmp[1] - 1] =2;
                    goodCount--;
                }
                //右
                if (tmp[1] < n -1 && grid[tmp[0]][tmp[1] +1] == 1){
                    queue.add(new int[]{tmp[0],tmp[1] +1});
                    grid[tmp[0] ][tmp[1]+ 1] =2;
                    goodCount--;
                }
            }
            count++;
        }
        if(!flag){
            return 0;
        }
        if (goodCount != 0 ){
            return -1;
        }

        return count -1;
    }
}
