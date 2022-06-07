package binarysearch;

/**
 * @author chengj
 * @Description 441.排列硬币 简单
 * @Date 2022/6/6
 */
//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
//
//
//
// 示例 1：
//
//
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
//
//
// 示例 2：
//
//
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
// Related Topics 数学 二分查找 👍 220 👎 0
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        long l = 0;
        long r = (long) n + 1;
        while (l + 1 != r){
            long mid = l + (r - l)/2;
            if (getMul(mid) <= n){
                l = mid;
            }else {
                r = mid;
            }
        }
        return (int) l;
    }
    public long getMul(long mid){
        if (mid%2==0){
            return (1 + mid) * (mid/2);
        }else {
            return (1 + mid) * (mid/2) + mid/2 +1;
        }

    }
    public static void main(String[] args) {
        ArrangeCoins ac = new ArrangeCoins();
        System.out.println(ac.arrangeCoins(1));
    }
}
