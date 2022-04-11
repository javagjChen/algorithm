package dp;

/**
 * @author chengj
 * @Description 494.目标和 中等
 * @Date 2022/4/7
 */
//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//
//
// 示例 2：
//
//
//输入：nums = [1], target = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000
//
// Related Topics 数组 动态规划 回溯 👍 1150 👎 0
public class FindTargetSumWays {

    /**
     * 回溯解法
     * @param nums
     * @param target
     * @return
     */
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {

        doFindTargetSumWays(nums,target,0,0);
        return count;
    }

    private void doFindTargetSumWays(int[] nums, int target,int index,int sum){
        if (index == nums.length){
            if (sum ==  target){
                count++;
            }
        }else {

            doFindTargetSumWays(nums,target,index + 1,sum - nums[index]);
            doFindTargetSumWays(nums,target,index + 1,sum + nums[index]);

        }
    }

    /**
     * 动态规划解法
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {

        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum < Math.abs(target)){
            return 0;
        }
        if ((sum +target)%2 == 1){
            return 0;
        }
        int size = (sum + target)/2;

        int[] dp = new int[size+1];
        dp[0] = 1;
        for (int i = 0;i < nums.length;i++){
            for (int j = size; j >= nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
