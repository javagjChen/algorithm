package stringandarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description 76.最小覆盖子串 困难
 * @Date 2022/8/2
 */
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
// 注意：
//
//
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
// 示例 3:
//
//
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 10⁵
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 2038 👎 0
public class MinWindow {

    public static void main(String[] args) {
        MinWindow mw = new MinWindow();
        System.out.println(mw.minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()){
            return "";
        } 
        // 哈希表：记录需要匹配到的各个元素的数目
        Map<Character,Integer> cnt = new HashMap<>();
        for (Character character : t.toCharArray()){
            cnt.put(character,cnt.getOrDefault(character,0) + 1);
        }
        // 记录需要匹配到的字符总数【need=0表示匹配到了】
        int need = t.length();

        int n = s.length();
        // 记录目标子串s[start, end]的起始和结尾
        int start = 0;
        int end = -1;
        // 符合题意的最短子串长度【初始化为一个不可能的较大值】
        int min_len = n + 1 ;
        // 滑动窗口的左右边界
        int left = 0;
        int right = 0 ;

        for ( ;right < n;right++){
            // 窗口右边界右移一位
            char ch = s.charAt(right);               // 窗口中新加入的字符
            if (cnt.containsKey(ch)){
                // 新加入的字符位于t中
                if (cnt.get(ch) > 0){
                    // 对当前字符ch还有需求
                    need -= 1;           // 此时新加入窗口中的ch对need有影响
                }
                cnt.put(ch,cnt.get(ch) - 1);
            }

            // 窗口左边界持续右移
            while (need == 0){
                // need=0，当前窗口完全覆盖了t
                if (right - left + 1 < min_len){
                    // 出现了更短的子串
                    min_len = right - left + 1;
                    start = left;
                    end = right;
                }

                ch = s.charAt(left);            // 窗口中要滑出的字符
                // 刚滑出的字符位于t中
                if (cnt.containsKey(ch)){

                    if (cnt.get(ch) >= 0){
                        need += 1;       // 此时滑出窗口的ch会对need有影响
                    }    // 对当前字符ch还有需求，或刚好无需求(其实此时只有=0的情况)
                    cnt.put(ch,cnt.get(ch) + 1);
                }
                left += 1;               // 窗口左边界+1
            }
        }
        return s.substring(start, end+1);

    }

}
