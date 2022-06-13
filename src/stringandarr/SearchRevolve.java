package stringandarr;

/**
 * @Description 33.搜索旋转排序数组 中等
 * @Author chengj
 * @Date 2022/1/17
 */
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10^4 <= target <= 10^4
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
// Related Topics 数组 二分查找 👍 2126 👎 0
public class SearchRevolve {

    /**
     * 二分法 二分之后一定有一部分是有序的
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return -1;
        }
        if (len ==1){
            return nums[0] == target? 0:-1;
        }
        int l = 0;
        int r = len -1;
        while (l <= r){
            int mid = l + ((r -l)>>2);
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid -1;
                }else {
                    l = mid +1;
                }
            }else {
                if (nums[mid] < target && nums[len -1] >= target){
                    l = mid +1;
                }else {
                    r = mid -1;
                }
            }
        }
        return -1;
    }

    /**
     * 蓝红二分解法
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int len = nums.length;
        int l = -1;
        int r = len;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target){
                return mid;
            }
            //0 - mid有序
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid;
                }else {
                    l = mid;
                }
            }else {
                // mid - len 有序
                if ( nums[mid] < target && target <= nums[len -1]){
                    l = mid;
                }else {
                    r = mid;
                }
            }
        }

        return -1;
    }
}
