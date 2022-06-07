package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 34.在排序数组中查找元素的第一个和最后一个位置 中等
 * @Date 2022/6/6
 */
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 👍 1742 👎 0
public class SearchRange {
    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = new int[]{1,4};
        int target = 1;
        System.out.println(Arrays.toString(sr.searchRange(nums,target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            if (nums[mid] < target){
                l = mid;
            }else {
                r = mid;
            }
        }
        if (r >= nums.length || nums[r] != target){
            return new int[]{-1,-1};
        }
        int end = r + 1;
        while (end < nums.length && nums[end] == target){
            end++;
        }
        return new int[]{r,end -1};
    }

}
