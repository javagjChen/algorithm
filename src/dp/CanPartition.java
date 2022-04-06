package dp;

/**
 * @author chengj
 * @Description
 * @Date 2022/4/6
 */
public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1,2,3,4,5,6,7}));
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum%2 ==1){
            return false;
        }
        int target = sum/2;
        int[] dp = new int[target+1];
        for (int i = 0; i < nums.length; i++){
            for (int j = target; j >= nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
