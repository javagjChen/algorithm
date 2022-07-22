package binarysearch;

/**
 * @author chengj
 * @Description 120.丑数3 中等
 * @Date 2022/7/22
 */
//给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
//
// 丑数是可以被 a 或 b 或 c 整除的 正整数 。
//
//
//
// 示例 1：
//
//
//输入：n = 3, a = 2, b = 3, c = 5
//输出：4
//解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
//
// 示例 2：
//
//
//输入：n = 4, a = 2, b = 3, c = 4
//输出：6
//解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
//
//
// 示例 3：
//
//
//输入：n = 5, a = 2, b = 11, c = 13
//输出：10
//解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
//
//
// 示例 4：
//
//
//输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
//输出：1999999984
//
//
//
//
// 提示：
//
//
// 1 <= n, a, b, c <= 10^9
// 1 <= a * b * c <= 10^18
// 本题结果在 [1, 2 * 10^9] 的范围内
//
// Related Topics 数学 二分查找 数论 👍 110 👎 0
public class NthUglyNumber {

    // greatest common divisor 最大公约数
    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    // least common multiple 最小公倍数
    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }



    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c);
        long abc = lcm(ab, c);
        //本题结果在 [1, 2 * 10^9] 的范围内，优化为 [min({a,b,c}), 2 * 10^9]
        long l = Math.min(Math.min(a,b),c)-1;
        long r = (long) (2e9)+1;
        while (l+1 != r) {
            long mid = (l+r)>>1;
            // 容斥原理：计算 cnt 为[1,mid]中的丑数个数
            long cnt = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (cnt < n) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return (int)r;
    }
}
