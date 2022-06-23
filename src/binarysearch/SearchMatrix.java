package binarysearch;

/**
 * @author chengj
 * @Description 74.搜索二维矩阵 中等
 * @Date 2022/6/8
 */
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10⁴ <= matrix[i][j], target <= 10⁴
//
// Related Topics 数组 二分查找 矩阵 👍 664 👎 0
public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            int l = -1;
            int r = n;
            while (l + 1 != r){
                int mid = l + (r - l)/2;
                if (matrix[i][mid] < target){
                    l = mid;
                }else if (matrix[i][mid] > target){
                    r = mid;
                }else {
                    return true;
                }
            }
            if (r < n && matrix[i][r] > target){
                return false;
            }
        }
        return false;
    }

    /**
     * 由左下角开始找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m -1;
        int y = 0;
        while (x >= 0 && y < n){
            if (matrix[x][y] > target){
                x--;
            }else if (matrix[x][y] < target){
                y++;
            }else {
                return true;
            }
        }
        return false;
    }

}
