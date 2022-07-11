package weekgame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chengj
 * @Description 6118.最小差值平方和 中等
 * @Date 2022/7/9
 */
//给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度为 n 。
//
// 数组 nums1 和 nums2 的 差值平方和 定义为所有满足 0 <= i < n 的 (nums1[i] - nums2[i])² 之和。
//
// 同时给你两个正整数 k1 和 k2 。你可以将 nums1 中的任意元素 +1 或者 -1 至多 k1 次。类似的，你可以将 nums2 中的任意元素 +
//1 或者 -1 至多 k2 次。
//
// 请你返回修改数组 nums1 至多 k1 次且修改数组 nums2 至多 k2 次后的最小 差值平方和 。
//
// 注意：你可以将数组中的元素变成 负 整数。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0
//输出：579
//解释：nums1 和 nums2 中的元素不能修改，因为 k1 = 0 和 k2 = 0 。
//差值平方和为：(1 - 2)2 + (2 - 10)2 + (3 - 20)2 + (4 - 19)² = 579 。
//
//
// 示例 2：
//
// 输入：nums1 = [1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1
//输出：43
//解释：一种得到最小差值平方和的方式为：
//- 将 nums1[0] 增加一次。
//- 将 nums2[2] 增加一次。
//最小差值平方和为：
//(2 - 5)2 + (4 - 8)2 + (10 - 7)2 + (12 - 9)² = 43 。
//注意，也有其他方式可以得到最小差值平方和，但没有得到比 43 更小答案的方案。
//
//
//
// 提示：
//
//
// n == nums1.length == nums2.length
// 1 <= n <= 10⁵
// 0 <= nums1[i], nums2[i] <= 10⁵
// 0 <= k1, k2 <= 10⁹
//
// 👍 14 👎 0
public class MinSumSquareDiff {

    public static void main(String[] args) {
        MinSumSquareDiff minSumSquareDiff = new MinSumSquareDiff();
        int[] nums1 = new int[]{1,4,10,12};
        int[] nums2 = new int[]{5,8,6,9};
        int k1 = 1;
        int k2 = 1;
        System.out.println(minSumSquareDiff.minSumSquareDiff2(nums1,nums2,k1,k2));
    }

    /**
     * 大根堆解法 -- 会超时
     * @param nums1
     * @param nums2
     * @param k1
     * @param k2
     * @return
     */
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] arr = new int[n];
        for (int i = 0;i < n;i++){
            arr[i] = Math.abs(nums1[i] - nums2[i]);
        }
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(n, Comparator.reverseOrder());
        for (int val :arr){
            priorityQueue.add((long)val);
        }
        int k = k1 + k2;
        while (k > 0&& !priorityQueue.isEmpty()){
            long poll = priorityQueue.poll();
            poll--;
            if (poll > 0){
                priorityQueue.add(poll);
            }
            k--;
        }
        long ans = 0;
        if (priorityQueue.isEmpty()){
            return 0;
        }
        for (long val : priorityQueue){
            long t = val * val;
            ans += t;
        }
        return ans;
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @param k1
     * @param k2
     * @return
     */
    public long minSumSquareDiff2(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1 + k2;
        long ans = 0L, sum = 0L;
        for (int i = 0; i < n; ++i) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
            sum += nums1[i];
            ans += (long) nums1[i] * nums1[i];
        }
        if (sum <= k) return 0;
        Arrays.sort(nums1);
        for (int i = n - 1; ; --i) {
            int m = n - i;
            long v = nums1[i], c = m * (v - (i > 0 ? nums1[i - 1] : 0));
            ans -= v * v;
            if (c < k) {
                k -= c;
                continue;
            }
            v -= k / m;
            return ans + k % m * (v - 1) * (v - 1) + (m - k % m) * v * v;
        }
    }
}