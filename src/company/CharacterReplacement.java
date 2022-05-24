package company;

/**
 * @author chengj
 * @Description 424.替换后的最长重复字符 中等
 * @Date 2022/5/17
 */
//给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
//
// 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
//
//
//
// 示例 1：
//
//
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
//
//
// 示例 2：
//
//
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 仅由大写英文字母组成
// 0 <= k <= s.length
//
// Related Topics 哈希表 字符串 滑动窗口 👍 613 👎 0
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int [] count = new int[26];
        int left = 0;
        int right = 0;
        // 窗口内 相同字母的最大值
        int hisMax = 0;
        for (;right < len;right++){
            int t = chars[right] - 'A';
            count[t]++;
            hisMax = Math.max(hisMax,count[t]);
            if (right - left + 1 > hisMax + k){
                // 窗口滑动
                count[chars[left] - 'A']--;
                left++;
            }
        }
        return len - left;
    }
}
