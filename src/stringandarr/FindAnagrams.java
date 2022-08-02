package stringandarr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengj
 * @Description 438.找到字符串中所有字母异位词 中等
 * @Date 2022/8/2
 */
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
//
//
//
// 示例 1:
//
//
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//
//
// 示例 2:
//
//
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//
//
//
//
// 提示:
//
//
// 1 <= s.length, p.length <= 3 * 10⁴
// s 和 p 仅包含小写字母
//
// Related Topics 哈希表 字符串 滑动窗口 👍 961 👎 0
public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams fa = new FindAnagrams();
        System.out.println(fa.findAnagrams("abab","ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()){
            return list;
        }
        // cnt是：目标字符和滑动窗口内对应字符的差值
        Map<Character, Integer> cnt = new HashMap<>();
        for (Character character : p.toCharArray()){
            cnt.put(character,cnt.getOrDefault(character,0) + 1);
        }
        int n = s.length();
        int need = p.length();

        int right = 0;
        for (;right < n;right++){
            char ch = s.charAt(right);
            if (cnt.containsKey(ch)){
                if (cnt.get(ch) > 0){
                    need--;
                }
                cnt.put(ch,cnt.get(ch) - 1);
            }
            int left = right - p.length();
            if (left >= 0){
                ch = s.charAt(left);
                if (cnt.containsKey(ch)){
                    // 目标字符数量 大于等于 滑动窗口内 对应字符数量
                    if (cnt.get(ch) >= 0){
                        need++;
                    }
                    cnt.put(ch,cnt.get(ch) + 1);
                }
            }
            if (need == 0){
                list.add(left + 1);
            }
        }
        return list;
    }
}
