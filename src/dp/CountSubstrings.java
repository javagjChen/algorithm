package dp;

/**
 * @author chengj
 * @Description 647.回文子串 中等
 * @Date 2022/4/24
 */
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
// 回文字符串 是正着读和倒过来读一样的字符串。
//
// 子字符串 是字符串中的由连续字符组成的一个序列。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//
//
// 示例 1：
//
//
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//
//
// 示例 2：
//
//
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 由小写英文字母组成
//
// Related Topics 字符串 动态规划 👍 844 👎 0
public class CountSubstrings {

    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int ans = 0;
        for (int i = len -1;i >= 0;i--){
            for (int j = i;j < len;j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <=1){
                        ans++;
                        dp[i][j] = true;
                    }else if (dp[i+1][j-1]){
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }
}
