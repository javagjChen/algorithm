package string;


/**
 * @author chengj
 * @Description 翻转字符串里的单词 中等
 * @Date 2022/2/28
 */
//给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
// 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
//
// 说明：
//
//
// 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
// 翻转后单词间应当仅用一个空格分隔。
// 翻转后的字符串中不应包含额外的空格。
//
//
//
//
// 示例 1：
//
//
//输入：s = "the sky is blue"
//输出："blue is sky the"
//
//
// 示例 2：
//
//
//输入：s = "  hello world  "
//输出："world hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
//
//
// 示例 3：
//
//
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
//
//
// 示例 4：
//
//
//输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
//
//
// 示例 5：
//
//
//输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 包含英文大小写字母、数字和空格 ' '
// s 中 至少存在一个 单词
//
//
//
//
//
//
//
// 进阶：
//
//
// 请尝试使用 O(1) 额外空间复杂度的原地解法。
//
// Related Topics 双指针 字符串 👍 465 👎 0
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("Alice does not even like bob"));
        //System.out.println(reverseWords.reverseWords("a good   example"));
    }
    public String reverseWords(String s) {
        // 去掉字符串中的空白
        StringBuilder sb = removeWhite(s);
        // 翻转字符串
        reverseStr(sb,0,sb.length() -1);
        // 翻转字母
        reverseWord(sb);
        
        return sb.toString();
    }

    private StringBuilder removeWhite(String s) {
        //先去掉字符串前后的空白
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' '){
            start++;
        }
        while ( s.charAt(end) == ' '){
            end--;
        }
        StringBuilder sb = new StringBuilder();
        // 再去掉字符串中间多余的空白
        while (start <= end){
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() -1 ) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    private void reverseStr(StringBuilder sb,int start,int end) {
        while (start < end){
            char tmp = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,tmp);
        }
    }

    private void reverseWord(StringBuilder sb) {
        int start =0;
        int end = 0;
        int len = sb.length();
        while (end < len){
            while (end < len && sb.charAt(end) != ' '){
                end++;
            }
            reverseStr(sb,start,end-1);
            start = end + 1;
            end++;
        }

    }
}
