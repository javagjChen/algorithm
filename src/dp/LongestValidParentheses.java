package dp;

/**
 * @author chengj
 * @Description 32.最长有效括号 困难
 * @Date 2022/2/9
 */
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
//
//
// 示例 2：
//
//
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
//
//
// 示例 3：
//
//
//输入：s = ""
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 3 * 10⁴
// s[i] 为 '(' 或 ')'
//
//
//
// Related Topics 栈 字符串 动态规划 👍 1640 👎 0
public class LongestValidParentheses {


    public static void main(String[] args) {
        System.out.println(longestValidParentheses2("()))"));
    }
    public static int longestValidParentheses(String s) {
        int ans = 0;

        int left = 0;
        int right = 0;
        int len = s.length();
        for (int i =0;i < len;i++){
            char c = s.charAt(i);
            if (c == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                ans = Math.max(ans,right*2);
            }else if (right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = len -1;i >= 0;i--){
            char c = s.charAt(i);
            if (c == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                ans = Math.max(ans,right*2);
            }else if (right < left){
                left = right = 0;
            }
        }
        return ans;
    }

    /**
     * 动态规划解法
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        if (s == null || s.length() ==0){
            return 0;
        }
        //已i结尾的最长有效字符长度是dp[i]
        int[] dp = new int[s.length()];

        int ans = 0;
        int pre;
        for (int i = 1;i<s.length();i++){
            // 如果是'(' 就不用判断了，dp[i] 就是0
            if (')' == s.charAt(i)){
                pre = i - dp[i-1] - 1;
                // 如果pre是')'的话，dp[i]肯定是0，
                // 因为如果pre是')'它要么没有和他组成有效的'(' 要么它的长度已经包含在dp[i-1]里了
                if (pre >= 0 && s.charAt(pre) == '('){
                    //dp[i]至少是dp[i - 1] + 2 pre不越界的情况下接上dp[pre -1]，dp[pre -1]是0也没关系
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre -1]:0);
                }
            }

            ans = Math.max(ans,dp[i]);
        }
        return ans;

    }


}
