package string;

/**
 * @author chengj
 * @Description 左旋转字符串 简单
 * @Date 2022/2/28
 */
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。
//
//
//
// 示例 1：
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
//
//
// 示例 2：
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
//
//
//
//
// 限制：
//
//
// 1 <= k < s.length <= 10000
//
// Related Topics 数学 双指针 字符串 👍 197 👎 0
public class ReverseLeftWords {

    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        System.out.println(reverseLeftWords.reverseLeftWords2("abcdefg",2));
    }
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] chars = new char[len];

        for (int i = 0;i < len;i++){
            if (i + n < len ){
                chars[i] = s.charAt(i + n);
            }else {
                chars[i] = s.charAt((i+n)%len);
            }
        }
        return new String(chars);
    }

    public String reverseLeftWords2(String s, int n) {
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = n;i < len;i++){
            sb.append(s.charAt(i));
        }
        for (int i = 0;i < n;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
