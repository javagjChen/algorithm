package dp;

/**
 * @author chengj
 * @Description 674.最长连续递增序列 简单
 * @Date 2022/4/21
 */
//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
// Related Topics 数组 👍 269 👎 0
public class FindLengthOfLCIS {

    /**
     * 贪心解法
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        if(nums.length ==1){
            return 1;
        }
        int t = 1;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] > nums[i-1]){
                t++;
            }else{
                t = 1;
            }
            ans = Math.max(t,ans);
        }
        return ans;
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = res > dp[i + 1] ? res : dp[i + 1];
        }
        return res;
    }
}
