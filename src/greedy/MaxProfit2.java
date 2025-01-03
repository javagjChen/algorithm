package greedy;

/**
 * @author chengj
 * @Description 122.买卖股票的最佳时机2 中等
 * @Date 2022/3/24
 */
//给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
//
// 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
//返回 你能获得的 最大 利润 。
//
//
//
// 示例 1:
//
//
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//
//
// 示例 2:
//
//
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//
//
// 示例 3:
//
//
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 3 * 10⁴
// 0 <= prices[i] <= 10⁴
//
// Related Topics 贪心 数组 动态规划 👍 1613 👎 0
public class MaxProfit2 {

    //7,1,5,3,6,4
    //7,6,4,3,1
    //1,2,3,4,5
    public int maxProfit(int[] prices) {

        int ans = 0;
        for (int i = 1;i < prices.length;i++){
            if (prices[i] > prices[i - 1]){
                ans += (prices[i] - prices[i - 1]);
            }
        }
        return ans;
    }

    /**
     * 动态规划解法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 1){
            return 0;
        }
        //dp[i][0] 持有股票所剩的现金
        //dp[i][1] 不持有股票所剩的现金
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        for (int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }
}
