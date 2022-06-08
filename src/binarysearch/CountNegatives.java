package binarysearch;

/**
 * @author chengj
 * @Description 1351.统计有序矩阵中的负数 简单
 * @Date 2022/6/8
 */
//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
//
//
//
// 示例 1：
//
//
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
//
//
// 示例 2：
//
//
//输入：grid = [[3,2],[1,0]]
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
// 1 <= m, n <= 100
// -100 <= grid[i][j] <= 100
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
// Related Topics 数组 二分查找 矩阵 👍 98 👎 0
public class CountNegatives {

    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0;i < m;i++){
            int l = -1;
            int r = n;
            while (l + 1!= r){
                int mid = l + (r - l)/2;
                if (grid[i][mid] >=0 ){
                    l = mid;
                }else {
                    r = mid;
                }
            }
            count += (n - r);
        }
        return count;
    }

    /**
     * 优化版本
     * @param grid
     * @return
     */
    public int countNegatives2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int l;
        int r = n;
        for (int i = 0;i < m;i++){
            l = -1;
            // 由于矩阵从上到下也是有序的，我们发现从上到下红色区域的左端点只能不动或者左移，
            // 所以我们可以设置下一行 r 指针的初始值为上一行 r 指针的最终值，这样可以缩小查找区间长度，对比上一版代码，
            // 我们只需要删除 r = n 这行代码就行


            while (l + 1!= r){
                int mid = l + (r - l)/2;
                if (grid[i][mid] >=0 ){
                    l = mid;
                }else {
                    r = mid;
                }
            }
            count += (n - r);
        }
        return count;
    }
}
