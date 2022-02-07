package math;

/**
 * @Description 除自身以外数组的乘积 中等
 * @Author chengj
 * @Date 2022/1/29
 */

//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。
//
//
//
// 示例:
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6]
//
//
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
// 进阶：
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
// Related Topics 数组 前缀和 👍 1037 👎 0
public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
    }
    public static int[] productExceptSelf(int[] nums) {
        if (nums ==null || nums.length <1){
            return null;
        }
        int [] result = new int[nums.length];
        result[0] = 1;
        for (int j =1;j < nums.length;j++){
            result[j] = result[j -1] * nums[j-1];
        }
        int R =1;
        for (int i = nums.length-1 ;i >=0;i--){
            result[i] = result[i] * R;
            R *= nums[i];
        }
        return result;
    }
}
