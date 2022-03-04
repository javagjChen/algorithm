package string;

/**
 * @author chengj
 * @Description 重复的子字符串 简单
 * @Date 2022/2/28
 */
//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
//
//
//
// 示例 1:
//
//
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
//
//
// 示例 2:
//
//
//输入: s = "aba"
//输出: false
//
//
// 示例 3:
//
//
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
//
//
//
//
// 提示：
//
//
//
//
// 1 <= s.length <= 10⁴
// s 由小写英文字母组成
//
// Related Topics 字符串 字符串匹配 👍 621 👎 0
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abaababaab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int end = 1;
        char tmp = s.charAt(0);
        String tmpStr = "";
        while (end < len){
            if (s.charAt(end) != tmp){
                end++;

            }else {
                tmpStr = s.substring(0,end);
                break;
            }

        }
        if (tmpStr.equals("") || tmpStr.equals(s)){
            return false;
        }
        int tmpLength = tmpStr.length();
        int start = end;
        s = s.substring(start);
        while (s.length() >= tmpLength){
            String t = s.substring(0,tmpLength);
            if (tmpStr.equals(t)){
                s = s.substring(start);
            }else {
                return false;
            }
        }
        return s.length() ==0 ;
    }
}
