package weekgame;

import java.util.Arrays;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/17
 */
public class SmallestSubarrays {
    public static void main(String[] args) {
        SmallestSubarrays ss = new SmallestSubarrays();
        int[] nums = new int[]{1,0,2,1,3};
        System.out.println(Arrays.toString(ss.smallestSubarrays(nums)));
    }
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int total = 0;
        for (int i = 0;i < n;i++){
            total |= nums[i];
        }
        int pre = 0;
        for (int i = 0;i < n;i++){

            for (int k =0 ;i < k;k++){
                pre |= nums[k];
            }
            int max = pre ^ total;
            int maxIndex = i;
            int t = nums[i];
            for (int j = i + 1;j < n;j++){

                t = t | nums[j];
                if(t == max){
                    maxIndex = j;
                    break;
                }

            }
            ans[i] = maxIndex - i + 1;
        }
        return ans;
    }
}
