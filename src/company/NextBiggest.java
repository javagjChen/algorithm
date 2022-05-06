package company;

import java.util.Arrays;

/**
 * @author chengj
 * @Description
 * @Date 2022/5/6
 */
public class NextBiggest {

    public static void main(String[] args) {
        NextBiggest ng = new NextBiggest();
        System.out.println(Arrays.toString(ng.nextBiggest(new int[]{1,2,1})));
    }

    public int[] nextBiggest(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans,-1);

        for (int i = 0;i < len;i++){
            for (int j = i + 1; j < i + len;j++){
                if (nums[j%len] > nums[i]){
                    ans[i] = nums[j%len];
                    break;
                }
            }
        }

        return ans;
    }
}
