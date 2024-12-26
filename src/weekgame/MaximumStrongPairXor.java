package weekgame;

import java.util.Arrays;

public class MaximumStrongPairXor {

    public static void main(String[] args) {
        MaximumStrongPairXor m = new MaximumStrongPairXor();

    }
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0;i < n;i++){
            for (int j = 0;j <n;j++){
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i],nums[j])){
                    int t = nums[i] ^ nums[j];
                    ans = Math.max(ans,t);
                }
            }
        }
        return ans;
    }

    public int maximumStrongPairXor2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0;i < n;i++){
            int t = nums[i];
            if ( i + 1 < n && nums[i+1] - t <= t){
                ans = Math.max(ans,nums[i+1] ^ t);
            }
        }
        return ans;
    }
}
