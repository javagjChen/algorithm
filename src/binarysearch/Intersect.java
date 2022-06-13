package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 350.两个数组的交集2 简单
 * @Date 2022/6/9
 */
public class Intersect {

    /**
     * 双指针解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int up = 0;
        int down = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] ans = new int[len];
        int k =0;
        while( up< nums1.length && down< nums2.length){
            if(nums1[up] == nums2[down]){
                ans[k++] = nums1[up];
                up++;
                down++;
            }else if (nums1[up] > nums2[down]){
                down++;
            }else if(nums1[up] < nums2[down]){
                up++;
            }

        }

        return Arrays.copyOfRange(ans,0,k);
    }

    /**
     * 蓝红二分解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 拿长度短的遍历
        if (len2 > len1){
            return intersect2(nums2,nums1);
        }
        //排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l = -1;
        int r;
        int[] ans = new int[len2];
        int index = 0;
        for (int val : nums2){
            r = len1;
            while (l + 1 != r){
                int mid = l + (r -l)/2;
                if (nums1[mid] < val){
                    l = mid;
                }else {
                    r = mid;
                }
            }
            if(r != len1 && nums1[r] == val){
                ans[index++] = val;
                //排除已经搜索到的元素，缩小搜索区间
                l++;
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
        int[] num2 = new int[]{5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
        Intersect intersect = new Intersect();
        System.out.println(Arrays.toString(intersect.intersect2(num1,num2)));
    }
}
