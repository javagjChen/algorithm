package math;

/**
 * @author chengj
 * @Description 152.乘积最大子数组 中等
 * @Date 2022/8/3
 */
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。
//
// 子数组 是数组的连续子序列。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
//
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 2 * 10⁴
// -10 <= nums[i] <= 10
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
//
// Related Topics 数组 动态规划 👍 1737 👎 0
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i =1;i < n;i++){
            int t = max;
            // 因为 num[i] 可能是负数，所以最大值可能会变最小值，最小值可能变最大值
            max = Math.max(Math.max(max * nums[i],nums[i]),min * nums[i]);
            min = Math.min(Math.min(min * nums[i],nums[i]),t * nums[i]);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
