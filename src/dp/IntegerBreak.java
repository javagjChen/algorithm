package dp;

/**
 * @author chengj
 * @Description 343.整数拆分 中等
 * @Date 2022/4/1
 */
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
//
// 返回 你可以获得的最大乘积 。
//
//
//
// 示例 1:
//
//
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//
// 示例 2:
//
//
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
//
//
// 提示:
//
//
// 2 <= n <= 58
//
// Related Topics 数学 动态规划 👍 771 👎 0
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

    /**
     * 贪心解法
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }

    /**
     * 数学解法
     * @param n
     * @return
     */
    public int integerBreak3(int n) {
        if(n == 2){
            return 1;
        }
        if(n ==3 ){
            return 2;
        }
        int ans = 1;
        while (n - 2 >= 0 ){
            if(( n - 3 >1 ) || n - 3 == 0 ){
                ans *= 3;
                n = n - 3;
            }else if(n - 2 >= 0){
                ans *=2;
                n = n -2;
            }
        }
        return ans;
    }

}
