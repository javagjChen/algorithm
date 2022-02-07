package stringandarr;

/**
 * @Description 寻找两个正序数组的中位数
 * @Author chengj
 * @Date 2022/1/14
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int [] merge = new int[len1 + len2];
        int index1 = 0;
        int index2 = 0;
        int i =0;
        while (index1 < len1 && index2 < len2){
            merge[i++] = nums1[index1] <= nums2[index2] ? nums1[index1++] : nums2[index2++];
        }
        while (index1 < len1){
            merge[i++] = nums1[index1++];
        }
        while (index2 < len2){
            merge[i++] = nums2[index2++];
        }
        double res = 0.0;
        int mLen = merge.length;
        double res1 = Double.parseDouble(String.valueOf(merge[mLen / 2]));
        if (mLen %2 ==0){
            res = Double.parseDouble(String.valueOf(merge[mLen/2 -1]))
                    + res1;
            res = res/2;
        }else {
            res = res1;
        }
        return res;
    }
}
