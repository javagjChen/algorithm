package stringandarr;

/**
 * @author chengj 旋转图像 中等
 * @Description
 * @Date 2022/2/11
 */
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//
//
// 示例 2：
//
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
//
//
// 提示：
//
//
// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
//
//
//
// Related Topics 数组 数学 矩阵 👍 1158 👎 0
public class Rotate {
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate.rotate2(matrix);
    }
    /**
     * 需要复制新数组的方法 规律：第一列 就是原来的最后一行，第二列就是原来的倒数第二行....
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int col = 0;col < n;col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = matrix[n - col -1][row];
            }
        }
        for (int i =0;i < n;i++){
            for (int j = 0;j< n;j++){
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    /**
     * 先水平翻转，再对角线翻转
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0;i < n/2;i++){
            for (int j = 0;j < n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
        // 对角线翻转
        for (int i = 0;i < n;i++){
            for (int j = 0;j < i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
