package binarysearch;

/**
 * @author chengj
 * @Description 69.x 的平方根  简单
 * @Date 2022/6/6
 */
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
// 示例 1：
//
//
//输入：x = 4
//输出：2
//
//
// 示例 2：
//
//
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//
//
// 提示：
//
//
// 0 <= x <= 2³¹ - 1
//
// Related Topics 数学 二分查找 👍 1032 👎 0
public class MySqrt {

    public int mySqrt(int x) {
        long l = -1;
        long r = (long)x + 1;
        while (l + 1 != r){
            long mid = l + (r -l)/2;
            if(mid * mid > x){
                r = mid;
            }else if (mid * mid < x){
                l = mid;
            }else{
                return (int)mid;
            }
        }
        return (int)l;
    }

}
