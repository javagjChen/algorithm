package partice;

/**
 * @author chengj
 * @Description 2110.股票平滑下跌阶段的数目 中等
 * @Date 2022/8/18
 */
//给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
//
// 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
//
// 请你返回 平滑下降阶段 的数目。
//
//
//
// 示例 1：
//
// 输入：prices = [3,2,1,4]
//输出：7
//解释：总共有 7 个平滑下降阶段：
//[3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
//注意，仅一天按照定义也是平滑下降阶段。
//
//
// 示例 2：
//
// 输入：prices = [8,6,7,7]
//输出：4
//解释：总共有 4 个连续平滑下降阶段：[8], [6], [7] 和 [7]
//由于 8 - 6 ≠ 1 ，所以 [8,6] 不是平滑下降阶段。
//
//
// 示例 3：
//
// 输入：prices = [1]
//输出：1
//解释：总共有 1 个平滑下降阶段：[1]
//
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 10⁵
// 1 <= prices[i] <= 10⁵
//
// Related Topics 数组 数学 动态规划 👍 17 👎 0
public class GetDescentPeriods {

    public static void main(String[] args) {
        GetDescentPeriods gdp = new GetDescentPeriods();
        int[] prices = new int[]{12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7};
        System.out.println(gdp.getDescentPeriods2(prices));
    }

    /**
     * 关键点：1、长度为 n 时 f(n) = f(n-1) + n - 1
     *        2、用滑动窗口分段
     * @param prices
     * @return
     */
    public long getDescentPeriods(int[] prices) {

        int n = prices.length;
        if(n == 1){
            return 1;
        }
        int start = 0;
        int end = 0;
        long sum = 0;
        for(int i = 0;i < n -1;i++){
            if(prices[i] - prices[i + 1] == 1){
                end++;
            }else{
                int len = end - start + 1;
                sum += getSum(len);
                start = i+1;
                end = i+1;
            }
        }
        int len = end - start + 1;
        sum += getSum(len);
        return n + sum;
    }

    public long getSum(int len){
        if(len == 1 ){
            return 0;
        }
        if(len == 2){
            return 1;
        }
        long [] dp = new long[len + 1];
        dp[3] = 3;
        for(int i = 4;i <= len;i++){
            dp[i] = dp[i-1] + (i-1);
        }
        return dp[len];
    }

    public long getDescentPeriods2(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 1;
        long ans = dp[0];
        for (int i =1;i < n;i++){
            if(prices[i] + 1 == prices[i-1]){
                dp[i] = dp[i - 1] + 1;
            }else {
                dp[i] = 1;
            }
            ans += dp[i];
        }
        return ans;
    }

    public long getDescentPeriods3(int[] prices) {

        int n = prices.length;
        int dp = 1;
        long ans = 1;
        for (int i =1;i < n;i++){
            if(prices[i] + 1 == prices[i-1]){
                dp = dp + 1;
            }else {
                dp = 1;
            }
            ans += dp;
        }
        return ans;
    }
}
