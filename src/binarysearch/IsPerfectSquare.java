package binarysearch;

/**
 * @author chengj
 * @Description 367.有效的完全平方数 简单
 * @Date 2022/6/1
 */
//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。
//
//
//
// 示例 1：
//
//
//输入：num = 16
//输出：true
//
//
// 示例 2：
//
//
//输入：num = 14
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics 数学 二分查找 👍 396 👎 0
public class IsPerfectSquare {

    public static void main(String[] args) {
        IsPerfectSquare ips = new IsPerfectSquare();
        System.out.println(ips.isPerfectSquare(25));
    }

    public boolean isPerfectSquare(int num) {
        long target = num;
        long left = -1;
        long right = target + 1;
        while (left + 1 != right){
            long mid = (left + (right - left)/2);
            long t = mid * mid;
            if (t < target){
                left = mid;
            }else if (t > target){
                right = mid;
            }else {
                return true;
            }
        }
        return false;
    }
}
