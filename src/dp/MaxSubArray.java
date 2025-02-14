package dp;

/**
 * @author chengj
 * @Description 53.最大数组合 简单
 * @Date 2022/3/24
 */
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划 👍 4597 👎 0
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray2(new int[]{2}));
    }

    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0],max = nums[0];
        for (int i = 1;i<nums.length;i++){
            pre = Math.max(pre + nums[i],nums[i]);
            max = Math.max(max,pre);
        }
        return max;
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
