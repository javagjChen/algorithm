package math;

/**
 * @Description 整数反转
 * @Author chengj
 * @Date 2022/1/12
 */
public class Reverse {

    public static void main(String[] args) {

        System.out.println(reverse(-123));
    }
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            if (result < Integer.MIN_VALUE/10 || result > Integer.MAX_VALUE/10){
                return 0;
            }
            int d = x%10;
            x /= 10;
            result = result * 10 + d;
        }
        return result;
    }
}
