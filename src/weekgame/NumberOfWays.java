package weekgame;

/**
 * @author chengj
 * @Description 2400.恰好移动 k 步到达某一位置的方法数目 中等
 * 第 309 场周赛 第2题
 * @Date 2022/9/6
 */
//给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置
//。
//
// 给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 10⁹ +
//7 取余 的结果。
//
// 如果所执行移动的顺序不完全相同，则认为两种方法不同。
//
// 注意：数轴包含负整数。
//
//
//
// 示例 1：
//
// 输入：startPos = 1, endPos = 2, k = 3
//输出：3
//解释：存在 3 种从 1 到 2 且恰好移动 3 步的方法：
//- 1 -> 2 -> 3 -> 2.
//- 1 -> 2 -> 1 -> 2.
//- 1 -> 0 -> 1 -> 2.
//可以证明不存在其他方法，所以返回 3 。
//
// 示例 2：
//
// 输入：startPos = 2, endPos = 5, k = 10
//输出：0
//解释：不存在从 2 到 5 且恰好移动 10 步的方法。
//
//
//
// 提示：
//
//
// 1 <= startPos, endPos, k <= 1000
//
// 👍 19 👎 0
public class NumberOfWays {
    public int MOD = (int) (1e9 + 7);
    public int numberOfWays(int startPos, int endPos, int k) {
        // dp[i][j] 表示走到 j 的位置走了 i 步
        // 因为有负数，所以整体加1000,endPos 的范围就变成了 1001 到 2000 走了 K步之后变成 1 到 3000
        long[][] dp = new long[1001][3002];
        startPos += 1000;
        endPos += 1000;
        // 初始化
        dp[0][startPos] = 1;

        for (int i =1;i <= k;i++){
            for (int j = 1; j < 3001;j++){
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }
        return (int) dp[k][endPos];
    }
}
