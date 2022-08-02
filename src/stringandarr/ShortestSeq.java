package stringandarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/2
 */
public class ShortestSeq {

    public int[] shortestSeq(int[] big, int[] small) {

        // 哈希表：记录需要匹配到的各个元素的数目
        Map<Integer,Integer> cnt = new HashMap<>();
        for (int val : small){
            cnt.put(val,cnt.getOrDefault(val,0) + 1);
        }
        // 记录需要匹配到的字符总数【need=0表示匹配到了】
        int need = small.length;

        int n = big.length;
        // 记录目标子串s[start, end]的起始和结尾
        int [] ans = new int[2];
        // 符合题意的最短子串长度【初始化为一个不可能的较大值】
        int min_len = n + 1 ;
        // 滑动窗口的左右边界
        int left = 0;
        int right = 0 ;

        for ( ;right < n;right++){
            // 窗口右边界右移一位
            int ch = big[right];               // 窗口中新加入的字符
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
                    ans[0] = left;
                    ans[1] = right;
                }

                ch = big[left];            // 窗口中要滑出的字符
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
        if (ans[0] == 0 && ans[1] ==0){
            return new int[]{};
        }
        return ans;
    }
}
