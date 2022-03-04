package string;

/**
 * @author chengj
 * @Description 实现strStr() 简单
 * @Date 2022/2/28
 */
//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。
//
//
//
// 说明：
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
//
//
//
// 示例 1：
//
//
//输入：haystack = "hello", needle = "ll"
//输出：2
//
//
// 示例 2：
//
//
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
//
//
// 示例 3：
//
//
//输入：haystack = "", needle = ""
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= haystack.length, needle.length <= 5 * 10⁴
// haystack 和 needle 仅由小写英文字符组成
//
// Related Topics 双指针 字符串 字符串匹配 👍 1268 👎 0
public class StrStr {

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi","issip"));
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 > len1){
            return -1;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2){
            if (haystack.charAt(index1) == needle.charAt(index2)){
                index1++;
                index2++;
            }else {
                index1++;
                index2 = 0;
            }
        }
        return index2 == len2 ? index1-index2 : -1;
    }
}
