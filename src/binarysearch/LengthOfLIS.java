package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 300.最长递增子序列 中等
 * @Date 2022/4/21
 */
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。
//
//
// 示例 1：
//
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//
//
// 示例 3：
//
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2500
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//
// Related Topics 数组 二分查找 动态规划 👍 2437 👎 0
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = new int[]{1,2,-10,-8,-7};
        System.out.println(lengthOfLIS.lengthOfLIS2(nums));
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        //定义 dp[i] 为考虑前i个元素，以第i个数字结尾的最长上升子序的长度，注意：nums[i] 必须被选取
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int ans = 0;
        //
        for (int i = 0;i < len;i++){
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    /**
     * 贪心 + 蓝红二分查找解法
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        // 先定义dp[i] 为 长度为i的最大上升子序的末尾元素的最小值
        int len = nums.length;
        int[] dp = new int[len + 1];
        int dpLen = 1;
        dp[1] = nums[0];
        for (int i = 1 ;i < len;i++){
            if(nums[i] > dp[dpLen]){
                // 长度+1 更新dp[i]
                dp[++dpLen] = nums[i];
            }else {
                // 蓝红二分查找 dp中第一个大于等于 nums[i] 的 ,然后替换
                // 因为dp 是从1 开始的
                int l = 0;
                int r = dpLen;
                while (l +1 != r){
                    int mid = l + (r - l)/2;
                    if (dp[mid] < nums[i]){
                        l = mid;
                    }else {
                        r = mid;
                    }
                }
                // 因为dp 是从1 开始的
                dp[r] = nums[i];

            }
        }
        return dpLen;
    }


}
