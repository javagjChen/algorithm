package math;

/**
 * @Description
 * @Author chengj
 * @Date 2022/1/12
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
    /**
     * 1、先去掉字符串两边的空格
     * 2、然后判断符号
     * 3、最后读取数字
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        // 去掉前后的空格
        s = s.trim();
        //如果为空，直接返回0
        if (s.length() == 0){
            return 0;
        }
        int len = s.length();
        int index = 0;
        int sign = 1;
        char[] chars = s.toCharArray();
        //判断符号
        if (chars[index] == '+' || chars[index] == '-'){
            sign = chars[index++] == '+' ? 1 : -1;
        }
        int result = 0;
        for (;index < len;index++){

            int tmp = chars[index] - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (tmp < 0 || tmp > 9){
                break;
            }
            //越界处理
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && tmp > Integer.MAX_VALUE %10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + tmp;
        }
        return sign * result;
    }
}
