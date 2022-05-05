package company;

/**
 * @author chengj
 * @Description 1071.字符串的最大公因子 简单 11
 * @Date 2022/4/18
 */
//对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
//
// 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 X 能除尽 str2 。
//
//
//
// 示例 1：
//
//
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
//
//
// 示例 2：
//
//
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
//
//
// 示例 3：
//
//
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
//
//
//
//
// 提示：
//
//
// 1 <= str1.length, str2.length <= 1000
// str1 和 str2 由大写英文字母组成
//
// Related Topics 数学 字符串 👍 229 👎 0
public class GcdOfStrings {

    public static void main(String[] args) {
        GcdOfStrings gos = new GcdOfStrings();
        System.out.println(gos.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX","TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
    public String gcdOfStrings(String str1, String str2) {

        for (int i = Math.min(str1.length(),str2.length());i >=1;i--)
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                String t = str1.substring(0, i);
                if (check(t, str1) && check(t, str2)) {
                    return t;
                }
            }
        return "";
    }

    private boolean check(String t, String str1) {
        int index = str1.length()/t.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1;i<=index;i++){
            stringBuilder.append(t);

        }
        return stringBuilder.toString().equals(str1);
    }
}
