package partice;

/**
 * @author chengj
 * @Description 791.自定义字符串排序 中等
 * @Date 2022/8/25
 */
//给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
//
// 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x
//也应该出现在 y 之前。
//
// 返回 满足这个性质的 s 的任意排列 。
//
//
//
// 示例 1:
//
//
//输入: order = "cba", s = "abcd"
//输出: "cbad"
//解释:
//“a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
//因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
//
// 示例 2:
//
//
//输入: order = "cbafg", s = "abcd"
//输出: "cbad"
//
//
//
//
// 提示:
//
//
// 1 <= order.length <= 26
// 1 <= s.length <= 200
// order 和 s 由小写英文字母组成
// order 中的所有字符都 不同
//
// Related Topics 哈希表 字符串 排序 👍 110 👎 0
public class CustomSortString {

    public static void main(String[] args) {
        CustomSortString css = new CustomSortString();
        System.out.println(css.customSortString("cba","abcd"));
    }
    /**
     * 关键点：逆向思维 不要老是盯着 order 可以先统计s 中的字符数量，然后再按照order来排序
     * @param order
     * @param s
     * @return
     */
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (int i = 0;i < s.length();i++){
            int t = s.charAt(i) - 'a';
            count[t]++;
        }
        StringBuilder sb = new StringBuilder();
        // 顺序遍历order中有的，
        for (int i = 0;i < order.length();i++){
            int t = order.charAt(i) - 'a';
            for(int j = 0; j < count[t];j++){
                sb.append(order.charAt(i));
            }
            // 置零
            count[t] = 0;
        }
        // 再把order中没有的放到最后
        for (int i =0;i < 26;i++){
            for (int j = 0;j < count[i];j++){
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
