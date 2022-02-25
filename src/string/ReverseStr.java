package string;

/**
 * @author chengj
 * @Description 反转字符串2 简单
 * @Date 2022/2/25
 */
//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例 1：
//
//
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
//
//
// 示例 2：
//
//
//输入：s = "abcd", k = 2
//输出："bacd"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由小写英文组成
// 1 <= k <= 10⁴
//
// Related Topics 双指针 字符串 👍 252 👎 0
public class ReverseStr {
    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        System.out.println(reverseStr.reverseStr("abcd",3));
    }
    public String reverseStr(String s, int k) {
        if (s.length() == 1 || k == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i =0;i < s.length();i += (2*k)){
            doReverse(chars,i,Math.min(i+k,s.length()) -1);
        }
        return new String(chars);
    }

    private void doReverse(char[] chars,int start,int end){
        while (start < end){
            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start] ^= chars[end];
            start++;
            end--;
        }
    }
}
