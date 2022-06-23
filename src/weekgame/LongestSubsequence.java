package weekgame;

/**
 * @author chengj
 * @Description 2311.小于等于 K 的最长二进制子序列 中等
 * @Date 2022/6/19
 */
//给你一个二进制字符串 s 和一个正整数 k 。
//
// 请你返回 s 的 最长 子序列，且该子序列对应的 二进制 数字小于等于 k 。
//
// 注意：
//
//
// 子序列可以有 前导 0 。
// 空字符串视为 0 。
// 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
//
//
//
//
// 示例 1：
//
// 输入：s = "1001010", k = 5
//输出：5
//解释：s 中小于等于 5 的最长子序列是 "00010" ，对应的十进制数字是 2 。
//注意 "00100" 和 "00101" 也是可行的最长子序列，十进制分别对应 4 和 5 。
//最长子序列的长度为 5 ，所以返回 5 。
//
//
// 示例 2：
//
// 输入：s = "00101001", k = 1
//输出：6
//解释："000001" 是 s 中小于等于 1 的最长子序列，对应的十进制数字是 1 。
//最长子序列的长度为 6 ，所以返回 6 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] 要么是 '0' ，要么是 '1' 。
// 1 <= k <= 10⁹
//
// 👍 15 👎 0
public class LongestSubsequence {
    public static void main(String[] args) {
        LongestSubsequence ls = new LongestSubsequence();
        System.out.println(ls.longestSubsequence("111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101",11713332));
        int a = 62;
        System.out.println(1L<<a);
        int len = a;
        long preSum = 1;
        while (len >0){
            len--;
            preSum *= 2;
        }
        System.out.println(preSum);
    }
    public int longestSubsequence(String s, int k) {
        long ans = 0;
        int len = s.length();
        long sum = 0;
        for (int i = len -1;i >= 0; i--){
            if (s.charAt(i) == '0'){
                ans++;
            }else {
                //题中k的取值范围为[1, 1e9]，cnt >30 后 1 << cnt 的值就大于1e9了
                if(ans <= 30 && sum + (1L<<ans) <= k){
                    sum += (1L<<ans);
                    ans++;
                }
            }
        }
        return (int)ans;
    }

}
