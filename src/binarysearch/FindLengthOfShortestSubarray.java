package binarysearch;

/**
 * @author chengj
 * @Description 1574.删除最短的子数组使剩余数组有序 中等
 * @Date 2022/6/28
 */
//给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
//
// 一个子数组指的是原数组中连续的一个子序列。
//
// 请你返回满足题目要求的最短子数组的长度。
//
//
//
// 示例 1：
//
//
//输入：arr = [1,2,3,10,4,2,3,5]
//输出：3
//解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
//另一个正确的解为删除子数组 [3,10,4] 。
//
// 示例 2：
//
//
//输入：arr = [5,4,3,2,1]
//输出：4
//解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
//
//
// 示例 3：
//
//
//输入：arr = [1,2,3]
//输出：0
//解释：数组已经是非递减的了，我们不需要删除任何元素。
//
//
// 示例 4：
//
//
//输入：arr = [1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^5
// 0 <= arr[i] <= 10^9
//
// Related Topics 栈 数组 双指针 二分查找 单调栈 👍 84 👎 0
public class FindLengthOfShortestSubarray {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        // 先找到3个数组的分界点left,right
        int left = 1;
        while (left < n && arr[left -1] <= arr[left]){
            left++;
        }
        //  整个数组都是非递减，直接返回0
        if (left == n ){
            return 0;
        }
        int right = n - 1;
        while (right - 1 > 0 && arr[right-1] <= arr[right]){
            right--;
        }

        // 最坏结果只保留right
        int ans = right;
        // 遍历left数组，查找满足要求的right数组的下标，2者直接即为需要删除的子数组，用ans保留其大小
        for (int i = 0;i < left;i++) {
            int target = arr[i];
            int l = right - 1;
            int r = n; // 搜索right区间[right,n-1]
            while (l+1 < r) {
                int mid = (l+r)>>1;
                if (arr[mid] < target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            ans = Math.min(ans, r-i-1);
        }
        return ans;

    }
}
