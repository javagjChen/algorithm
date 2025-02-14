package binarysearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description 209.长度最小的子数组 中等
 * @Date 2022/2/17
 */
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 945 👎 0
public class MinSubArrayLen {

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen3(11,new int[]{1,1,1,1,1,1,1,1}));
    }
    /**
     * 暴力解法
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i =0;i < nums.length;i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }

        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }

    /**
     * 滑动窗口 窗口又小到大，会超时
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        for (int index = 1;index <= nums.length;index++){
            for (int i = 0;i < nums.length - (index -1);i++){
                int sum = 0;
                int k = index;
                while (k >0){
                    sum += nums[i + (k -1)];
                    k--;
                }
                if (sum >= target){
                    return index;
                }
            }
        }

        return 0;
    }

    /**
     * 滑动窗口
     * @param target 7
     * @param nums 2,3,1,2,4,3
     * @return
     */
    public int minSubArrayLen3(int target, int[] nums) {
        //返回的结果
        int min = Integer.MAX_VALUE;
        // 这里用queue代替容易理解，只标记开始位置比较节约空间
        int start = 0;
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum += nums[i];
            while (sum >= target){
                // 如果queue代替的话，直接比较queue.size()和min
                min = Math.min(min,i - start +1);
                sum -= nums[start++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 用队列来保存滑动窗口
     * @param target
     * @param nums
     * @return
     */
    // 2,3,1,2,4,3
    public int minSubArrayLenPractice(int target, int[] nums){
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i < nums.length;i++){
            queue.add(nums[i]);
            sum += nums[i];
            while (sum >= target){
                ans = Math.min(ans,queue.size());
                sum -= queue.poll();
            }

        }
        return ans ==Integer.MAX_VALUE? 0:ans;
    }

    /**
     * 蓝红二分查找解法
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen4(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len;i++){
            preSum[i] = preSum[i - 1] + nums[i -1];
        }

        for (int i = 0;i < len;i++){
            int t = target + preSum[i];
            int l = -1;
            int r = len + 1;
            while (l + 1 != r) {
                int mid = l + (r -l)/2;
                if (preSum[mid] >= t){
                    r = mid;
                }else {
                    l = mid;
                }
            }
            if (r != len + 1){
                ans = Math.min(ans,r - i);
            }
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }
}
