package stringandarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description 567.字符串的排列 中等
 * @Date 2022/8/2
 */
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。
//
//
//
// 示例 1：
//
//
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
//
//
// 示例 2：
//
//
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 10⁴
// s1 和 s2 仅包含小写字母
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 734 👎 0
public class CheckInclusion {

    public static void main(String[] args) {
        CheckInclusion ci = new CheckInclusion();
        System.out.println(ci.checkInclusion("ab","eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        // 哈希表：记录需要匹配到的各个元素的数目，这里实际是 目标字符 减去 窗口中的字符，当窗口变大时，cnt 就可能会小 当窗口变小时，cnt就可能变大
        Map<Character,Integer> cnt = new HashMap<>();
        for (Character character : s1.toCharArray()){
            cnt.put(character,cnt.getOrDefault(character,0) + 1);
        }
        // 记录需要匹配到的字符总数【need=0表示匹配到了】
        int need = s1.length();

        int n = s2.length();

        // 滑动窗口的左右边界

        int right = 0 ;

        for ( ;right < n;right++){
            // 窗口右边界右移一位
            char ch = s2.charAt(right);               // 窗口中新加入的字符
            if (cnt.containsKey(ch)){
                // 新加入的字符位于t中
                if (cnt.get(ch) > 0){
                    // 对当前字符ch还有需求
                    need -= 1;           // 此时新加入窗口中的ch对need有影响
                }
                cnt.put(ch,cnt.get(ch) - 1);
            }
            int left = right - s1.length();
            if (left >= 0){
                ch = s2.charAt(left);
                if (cnt.containsKey(ch)){
                    if (cnt.get(ch) >= 0){
                        need += 1;
                    }
                    cnt.put(ch,cnt.get(ch) + 1);
                }
            }
            // 窗口左边界持续右移
            if (need == 0){
                return true;
            }
        }
        return false;
    }
}
