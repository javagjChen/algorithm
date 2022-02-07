package stringandarr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 螺旋矩阵 中等
 * @Author chengj
 * @Date 2022/1/30
 */
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟 👍 971 👎 0
public class SpiralOrder {
    public static void main(String[] args) {
        int [] [] matrix =new int [][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
    /**
     * 一层一层来
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return order;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0,left = 0,right = rows -1,bottom = columns -1;
        while (left <=right && top <= bottom){
            // 向右
            for (int column = left; column <= right;column++){
                order.add(matrix[top][column]);
            }
            // 向下
            for (int row = top +1; row <= bottom;row++){
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom){
                // 向左
                for (int column = right -1; column >= left +1;column--){
                    order.add(matrix[bottom][column]);
                }
                // 向上
                for (int row = bottom;row >= top+1;row--){
                    order.add(matrix[row][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return order;
    }
}
