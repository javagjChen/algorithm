package binarysearch;

/**
 * @author chengj
 * @Description 633.平方数之和 中等
 * @Date 2022/6/10
 */
//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。
//
//
//
// 示例 1：
//
//
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
//
//
// 示例 2：
//
//
//输入：c = 3
//输出：false
//
//
//
//
// 提示：
//
//
// 0 <= c <= 2³¹ - 1
//
// Related Topics 数学 双指针 二分查找 👍 361 👎 0
public class JudgeSquareSum {

    public static void main(String[] args) {
        JudgeSquareSum jss = new JudgeSquareSum();
        System.out.println(jss.judgeSquareSum(2147482647));
        System.out.println((long)Math.sqrt(2147482646));
        System.out.println((long)Math.sqrt(2147482647));
        System.out.println((long)46341 * 46341);
    }
    /**
     * 也是采用蓝红二分，但和蓝红作者写的不一样，看看能不能解出来
     * 注意 i 要定义成 long 防止越界
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c;i++){
            // 这里是a平方
            long a = i * i;
            long l = i- 1;
            long r = (long)Math.sqrt(c) + 1;
            while (l + 1 != r){
                long mid = l + (r - l)/2;
                // 这里是b的平方
                long b = mid * mid;
                if (a + b == c){
                    // 找到结果
                    return true;
                }else if (a + b >c){
                    r = mid;
                }else {
                    l = mid;
                }
            }
        }
        return false;
    }
    public boolean judgeSquareSum2(int c) {
        for (long i = 0; i * i <= c; i++) {
            long a = i * i;
            long l = i;
            long r = (long) Math.sqrt(c);
            while (l <= r) {
                long mid = l + (r - l) / 2;
                long b = mid * mid;
                if (a + b == c) {
                    return true;
                } else if (a + b < c) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * 双指针
     * @param c
     * @return
     */
    public boolean judgeSquareSum3(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

}
