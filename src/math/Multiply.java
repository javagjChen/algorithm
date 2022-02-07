package math;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//0
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串 模拟 👍 817 👎 0
/**
 * @Description 字符串相乘
 * @Author chengj
 * @Date 2022/1/18
 */
public class Multiply {

    public static void main(String[] args) {
        System.out.println(multiply("9","99"));
    }
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();

        String result = "0";
        for (int i = n -1;i >=0;i--){
            int n1 = num2.charAt(i) - '0';
            // 补0
            StringBuffer tmp = new StringBuffer();
            for (int j = i +1; j <= n -1;j++){
                tmp.append("0");
            }
            int add = 0;
            // 一位一位相乘
            for (int j = m -1; j>= 0;j--){
                int m1 = num1.charAt(j) - '0';
                int sum = m1 * n1 + add;
                tmp.append(sum%10);
                add = sum/10;
            }
            if (add != 0){
                tmp.append(add);
            }
            result = addString(result,tmp.reverse().toString());
        }
        return result;
    }

    private static String addString(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();

    }
}
