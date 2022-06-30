package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 1498.满足条件的的子序列数目 中等
 * @Date 2022/6/29
 */
public class NumSubseq {
    private static final long MOD = 1000000007;

    public int numSubseq(int[] nums, int target) {
        long ans = 0;
        Arrays.sort(nums);
        // 预处理 rs存储了2 的多少次方

        long[] rs = new long[nums.length];
        rs[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            rs[i] = (rs[i - 1] << 1) % MOD;
        }

        for (int i = 0; i < nums.length; ++i) {
            int l = i -1;
            int r = nums.length;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] + nums[i] <= target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            long contribute = (l >= i) ? rs[l-i] : 0;
            if (l > -1 && nums[l] + nums[i] <= target) {
                ans = (ans + contribute ) % MOD;
            }
        }
        return (int) ans;
    }

}
