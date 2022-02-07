package stringandarr;

/**
 * @Description 螺旋矩阵2 中等
 * @Author chengj
 * @Date 2022/1/30
 */
//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组 矩阵 模拟 👍 584 👎 0
public class GenerateMatrix {
    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }
    public static int[][] generateMatrix(int n) {
        if (n == 0){
            return null;
        }
        int [] [] res = new int[n][n];
        int index = 1;
        int top =0,left =0,right = n-1,bottom = n-1;
        while (top <= bottom&& left <= right){
            // 向右
            for (int column = left;column <= right;column ++){
                res[top][column] = index++;
            }
            // 向下
            for (int row = top + 1;row <= bottom;row ++){
                res[row][right] = index++;
            }
            if (top < bottom && left < right){
                // 向左
                for (int column = right-1;column >= left;column --){
                    res[bottom][column] = index++;
                }
                // 向上
                for (int row = bottom -1;row >= top +1;row--){
                    res[row][left] = index++;
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return res;
    }
}
