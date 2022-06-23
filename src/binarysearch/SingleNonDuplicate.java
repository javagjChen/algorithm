package binarysearch;

/**
 * @author chengj
 * @Description 540.有序数组中的单一元素 中等
 * @Date 2022/6/23
 */
//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
//
// 请你找出并返回只出现一次的那个数。
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
//
//
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁵
//
// Related Topics 数组 二分查找 👍 519 👎 0
public class SingleNonDuplicate {

    public static void main(String[] args) {
        SingleNonDuplicate snd = new SingleNonDuplicate();
        System.out.println(snd.singleNonDuplicate2(new int[]{1,1,2}));
    }

    /**
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int l = -1;
        int r = nums.length;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            int target = nums[mid];
            int count = 0;
            for(int val: nums){
                if(val <= target){
                    count++;
                }
            }
            if(count%2 == 0){
                l = mid;
            }else{
                r = mid;
            }
        }
        return nums[r];
    }

    /**
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = -1;
        int r = nums.length;
        while (l + 1 != r){
            int mid = (r + l)>>1;
            // 异或
            if ((mid ^ 1) < nums.length && nums[mid] == nums[mid ^ 1]){
                l = mid;
            }else {
                r = mid;
            }
        }
//        int l = 0, r = nums.length - 1;
//        while (l < r) {
//            int mid = l + r >> 1;
//            if (nums[mid] == nums[mid ^ 1]) l = mid + 1;
//            else r = mid;
//        }


        return nums[r];
    }

    public int singleNonDuplicate3(int[] nums) {
        int ans = 0;
        for (int val : nums){
            // 异或自己等于零，零异或任何数等于任何数
            ans ^= val;
        }
        return ans;
    }
}
