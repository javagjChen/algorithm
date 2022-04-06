package stringandarr;

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
        System.out.println(longestValidParentheses(")()())"));
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
}
