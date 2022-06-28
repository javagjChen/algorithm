package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/26
 */
public class MaximumsSplicedArray {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] arr = new int[n ];


        for (int i = 0;i < n;i++){
            arr[i] = Math.max(nums1[i],nums2[i]);
        }


        return 0;


    }
}
