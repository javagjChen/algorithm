package sort;

/**
 * @author chengj
 * @Description 搜索插入位置 简单
 * @Date 2022/2/14
 */
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,3,5,6], target = 5
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums = [1,3,5,6], target = 2
//输出: 1
//
//
// 示例 3:
//
//
//输入: nums = [1,3,5,6], target = 7
//输出: 4
//
//
// 示例 4:
//
//
//输入: nums = [1,3,5,6], target = 0
//输出: 0
//
//
// 示例 5:
//
//
//输入: nums = [1], target = 0
//输出: 0
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 为无重复元素的升序排列数组
// -10⁴ <= target <= 10⁴
//
// Related Topics 数组 二分查找 👍 1344 👎 0
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6},0));
    }
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + ((right-left)>>1);
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
