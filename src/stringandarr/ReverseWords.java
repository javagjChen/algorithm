package stringandarr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 反转字符串中的单词 3
 * @Author chengj
 * @Date 2022/1/21
 */
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例：
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
//
//
//
// 提示：
//
//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 双指针 字符串 👍 394 👎 0
public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords2("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {
        String [] strArr = s.split(" ");
        List<String> list = new ArrayList<>();
        for (String str : strArr){
            StringBuffer sb = new StringBuffer(str);
            list.add(sb.reverse().toString());
        }
        return String.join(" ",list);
    }

    public static String reverseWords2(String s) {
        if (s.length() < 2){
            return s;
        }
        StringBuffer result = new StringBuffer();
        char [] chars = s.toCharArray();
        StringBuffer tmp = new StringBuffer();
        for (int i =0;i < chars.length;i++){
            if (chars[i] != ' '){
                tmp.append(chars[i]);
            }
            if (i == chars.length -1 || chars[i] == ' ') {
                String str = reverse(tmp);
                tmp.delete(0, tmp.length());
                result.append(str);

            }
            if (chars[i] == ' '){
                result.append(' ');
            }
        }
        return result.toString();
    }

    private static String reverse(StringBuffer tmp) {
        int len = tmp.length();
        char [] chars = tmp.toString().toCharArray();
        for (int i = 0;i < len/2;i++){
            char c = chars[i];
            chars[i] = chars[len -1 -i];
            chars[len -1 -i] = c;
        }
        return new String(chars);
    }
}
