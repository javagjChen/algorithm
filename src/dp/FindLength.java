package dp;

/**
 * @author chengj
 * @Description 728.最长重复子数组 中等
 * @Date 2022/4/22
 */
//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
//
//
// 示例 2：
//
//
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 100
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 674 👎 0
public class FindLength {

    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        //dp[i][j] 表示下标为i-1 和 j-1最长重复子数组
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 1;i<=nums1.length;i++){
            for (int j = 1; j <= nums2.length;j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if (ans < dp[i][j]){
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }
}
