package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 1648.销售价值减少的颜色球 中等
 * @Date 2022/7/1
 */
//你有一些球的库存 inventory ，里面包含着不同颜色的球。一个顾客想要 任意颜色 总数为 orders 的球。
//
// 这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的 同色球 的数目。比方说还剩下 6 个黄球，那么顾客买第一个黄球的时候该黄球的价值为 6 。
//这笔交易以后，只剩下 5 个黄球了，所以下一个黄球的价值为 5 （也就是球的价值随着顾客购买同色球是递减的）
//
// 给你整数数组 inventory ，其中 inventory[i] 表示第 i 种颜色球一开始的数目。同时给你整数 orders ，表示顾客总共想买的球数
//目。你可以按照 任意顺序 卖球。
//
// 请你返回卖了 orders 个球以后 最大 总价值之和。由于答案可能会很大，请你返回答案对 10⁹ + 7 取余数 的结果。
//
//
//
// 示例 1：
//
//
//输入：inventory = [2,5], orders = 4
//输出：14
//解释：卖 1 个第一种颜色的球（价值为 2 )，卖 3 个第二种颜色的球（价值为 5 + 4 + 3）。
//最大总和为 2 + 5 + 4 + 3 = 14 。
//
//
// 示例 2：
//
//
//输入：inventory = [3,5], orders = 6
//输出：19
//解释：卖 2 个第一种颜色的球（价值为 3 + 2），卖 4 个第二种颜色的球（价值为 5 + 4 + 3 + 2）。
//最大总和为 3 + 2 + 5 + 4 + 3 + 2 = 19 。
//
//
// 示例 3：
//
//
//输入：inventory = [2,8,4,10,6], orders = 20
//输出：110
//
//
// 示例 4：
//
//
//输入：inventory = [1000000000], orders = 1000000000
//输出：21
//解释：卖 1000000000 次第一种颜色的球，总价值为 500000000500000000 。 500000000500000000 对 109 +
//7 取余为 21 。
//
//
//
//
// 提示：
//
//
// 1 <= inventory.length <= 10⁵
// 1 <= inventory[i] <= 10⁹
// 1 <= orders <= min(sum(inventory[i]), 10⁹)
//
// Related Topics 贪心 数组 数学 二分查找 排序 堆（优先队列） 👍 64 👎 0
public class MaxProfit {

    public int mod = (int) (1e9) + 7;

    // 找到购买数量 大于 orders 的最小值
    public boolean moreThanOrders(int[] inventory, int orders, int base) {
        int cnt = 0;
        for (int x : inventory) {
            cnt += Math.max(x-base, 0);
            if (cnt > orders) {
                return true;
            }
        }
        return false;
    }

    public int maxProfit(int[] inventory, int orders) {
        int max = Arrays.stream(inventory).max().getAsInt();
        int l = -1, r = max+1;
        while (l+1 != r) {
            int mid = (l+r)>>1;
            // 找到购买数量 大于 orders 的最小值 对应的 基数base 就是减到多少为止的那个数
            if (moreThanOrders(inventory, orders, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        long ans = 0;
        for (int x : inventory) {
            if (x > r) {
                // 计算 价值
                ans += (long)(x+r+1)*(x-r)/2;
                ans %= mod;
                // orders 数减去 数量
                orders -= x-r;
            }
        }
        // 加上 剩下的orders 数 乘以要base
        ans += (long)r * orders;
        ans %= mod;
        return (int)ans;
    }


    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(new int[]{5,3},6));
    }
}
