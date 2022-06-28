package binarysearch;

/**
 * @author chengj
 * @Description 162.寻找峰值 中等
 * @Date 2022/6/26
 */
//峰值元素是指其值严格大于左右相邻值的元素。
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。
//
// 示例 2：
//
//
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// -2³¹ <= nums[i] <= 2³¹ - 1
// 对于所有有效的 i 都有 nums[i] != nums[i + 1]
//
// Related Topics 数组 二分查找 👍 836 👎 0

public class FindPeakElement {

    /**
     * 蓝红二分不适用？？？？
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        // 先单独看下两个端点的情况：
        if (nums[0] > nums[1]) return 0;
        if (nums[n-1] > nums[n-2]) return n-1;
        // 此时[0] < [1] 上坡曲线 && [n-2] > [n-1] 下坡曲线，所以，在[1 ... n-2]范围上，必然存在峰值点，二分：
        int l = 0, r = n-1;
        while (l < r) {
            int m = l + (r-l)/2;
            if (nums[m] > nums[m-1] && nums[m] > nums[m+1]) return m; // m就是峰值点
            // [m]>[m-1]，m左侧处于上坡，由于[n-2]>[n-1] 是下坡，则[m ...]必然存在峰值，右侧二分
            if (nums[m] > nums[m-1]) {
                l = m;
            } else { // [m]<[m-1]，m左侧处于下坡，由于[0]<[1] 是上坡，则[... m]必然存在峰值，左侧二分
                r = m;
            }
        }
        return 0;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        // 先单独看下两个端点的情况：
        if (nums[0] > nums[1]) return 0;
        if (nums[n-1] > nums[n-2]) return n-1;
        // 此时[0] < [1] 上坡曲线 && [n-2] > [n-1] 下坡曲线，所以，在[1 ... n-2]范围上，必然存在峰值点，二分：
        int l = -1, r = n;
        while (l +1 != r) {
            int m = l + (r-l)/2;
            //if (nums[m] > nums[m-1] && nums[m] > nums[m+1]) return m; // m就是峰值点
            // [m]>[m-1]，m左侧处于上坡，由于[n-2]>[n-1] 是下坡，则[m ...]必然存在峰值，右侧二分
            if (( m < n -1) && nums[m] < nums[m+1]) {
                l = m;
            } else { // [m]<[m-1]，m左侧处于下坡，由于[0]<[1] 是上坡，则[... m]必然存在峰值，左侧二分
                r = m;
            }
        }
        return r;
    }
}
