package weekgame;

import java.util.Arrays;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/26
 */
public class MaximumsSplicedArray {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        // 重复两次交换
        return Math.max(max(nums1, nums2), max(nums2, nums1));


    }
    //用nums1的较小区间换nums2的较大区间
    public int max(int[] nums1, int[] nums2) {
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < nums1.length; i++) {
            //计算差值
            sum += (nums2[i] - nums1[i]);
            //小于0 重新计算
            if (sum < 0) {
                sum = 0;
            }
            temp = Math.max(temp, sum);
        }
        int sum1 = Arrays.stream(nums1).sum();
        return sum1 + temp;
    }


}
