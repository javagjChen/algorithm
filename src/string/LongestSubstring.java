package string;

/**
 * @author chengj
 * @Description 395.至少有 K 个重复字符的最长子串 中等
 * @Date 2022/5/10
 */
//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
//
//
//
// 示例 1：
//
//
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
//
//
// 示例 2：
//
//
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由小写英文字母组成
// 1 <= k <= 10⁵
//
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 682 👎 0
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.longestSubstring("ababacb",3));
    }
    public int longestSubstring(String s, int k) {
        // 结果
        int ans = 0;

        int len = s.length();
        char[] chars = s.toCharArray();
        // 我们可以枚举最大长度所包含的字符类型数量，
        // 答案必然是 [1, 26]，即最少包含 1 个字母，最多包含 26 个字母。
        for(int p = 1; p <=26;p++){
            int[] count = new int[26];
            // 滑动窗口里到达k次的字母种类数
            int sum = 0;
            // 滑动窗口里字母的种类数
            int tot = 0;
            // i是有边界, j是左边界
            for (int i = 0,j =0;i < len;i++){
                // 临时变量
                int ct = chars[i] - 'a';
                count[ct]++;
                // 第一次出现 种类数加1
                if (count[ct] == 1){
                    tot++;
                }
                // 字母达到k次
                if (count[ct] == k){
                    sum++;
                }
                // 当区间所包含的字符种类数量 tot 超过了当前限定的数量 p，
                // 那么我们要删除掉一些字母，即「左指针」右移
                while (tot > p){
                    int t = chars[j] - 'a';
                    j++;
                    count[t]--;
                    if (count[t] == 0){
                        tot--;
                    }
                    if (count[t] == k -1) {
                        sum--;
                    }
                }
                if (tot == sum){
                    // 活动窗口的长度
                    ans = Math.max(ans,i-j+1);
                }
            }
        }
        return ans;
    }

}
