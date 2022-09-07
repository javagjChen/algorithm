package greedy;

import java.util.*;

/**
 * @author chengj
 * @Description 划分字母区间 中等
 * @Date 2022/2/16
 */
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
//
//
// 示例：
//
//
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//
//
//
// 提示：
//
//
// S的长度在[1, 500]之间。
// S只包含小写字母 'a' 到 'z' 。
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 658 👎 0
public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }
    /**
     *  ababcbacadefegdehijhklij
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        // 先遍历数组拿到每个字母出现的最后的位置
        int len = s.length();
        // 存储26个字母
        // s.charAt(i) - 'a' 对应 0到25
        // 找到每个字符的最大位置
        int[] store = new int[26];
        for (int i = 0;i < len;i++){
            store[s.charAt(i) - 'a'] = i;
        }
        // 每个片段的开始和结束位置
        int start = 0,end = 0;
        for (int i =0 ;i<len;i++){
            end = Math.max(end,store[s.charAt(i) - 'a']);
            // 片段结束位置
            if (i == end){
                ans.add(end - start +1);
                start = end +1;
            }
        }
        return ans;
    }


}
