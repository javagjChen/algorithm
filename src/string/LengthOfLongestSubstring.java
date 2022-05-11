package string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description 3.无重复字符的最长子串 中等
 * @Date 2022/5/9
 */
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口 👍 7538 👎 0
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring sols = new LengthOfLongestSubstring();
        System.out.println(sols.lengthOfLongestSubstring("abcabcbb"));
    }

    // pwwkew
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int ans = 1;
        // 滑动窗口
        Queue<Character> queue = new LinkedList<>();
        for (int i =0;i < s.length();i++){
            if (queue.contains(s.charAt(i))) {
                // 有重复时，一直弹出
                while (queue.contains(s.charAt(i))) {
                    queue.poll();
                }
            }
            queue.add(s.charAt(i));
            ans = Math.max(ans,queue.size());
        }
        return ans;
    }
}
