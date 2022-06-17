package binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 287.寻找重复数 中等
 * @Author chengj
 * @Date 2022/1/11
 */
//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,4,2,2]
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [3,1,3,4,2]
//输出：3
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁵
// nums.length == n + 1
// 1 <= nums[i] <= n
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
//
//
//
//
// 进阶：
//
//
// 如何证明 nums 中至少存在一个重复的数字?
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
//
// Related Topics 位运算 数组 双指针 二分查找 👍 1783 👎 0
public class FindDuplicate {

    public static void main(String[] args) {

    }

    /**
     * 寻找重复数 不符合规则的解法
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i], i);
        }
        return 0;
    }

    /**
     * 寻找重复数
     * 构建一个链表，实际上就是找环的入口和链表的 环形链表2 一样
     * @Linked DetectCycle
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    /**
     * 二分解法
     * 我们定义 cnt[i] 表示 nums 数组中小于等于 i 的数有多少个，
     * 假设我们重复的数是 target，那么 [1,target−1]里的所有数满足 <=i，[target,n] 里的所有数满足 >i，具有单调性。
     * 左边蓝色区域表示不受重复元素影响的区域，右边红色区域表示受重复元素影响的区域
     *
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            if (checkLittleOrThen(nums,mid) <= mid){
                l = mid;
            }else {
                r = mid;
            }
        }
        return r;
    }

    private int checkLittleOrThen(int[] nums, int target) {
        int count = 0;
        for (int val : nums){
            if (val <= target){
                count++;
            }
        }
        return count;
    }
}
