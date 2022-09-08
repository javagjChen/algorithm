package partice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author chengj
 * @Description 942.增减字符串匹配 简单
 * @Date 2022/9/6
 */
//由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
//
//
// 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
// 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
//
//
// 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
//
//
//
// 示例 1：
//
//
//输入：s = "IDID"
//输出：[0,4,1,3,2]
//
//
// 示例 2：
//
//
//输入：s = "III"
//输出：[0,1,2,3]
//
//
// 示例 3：
//
//
//输入：s = "DDI"
//输出：[3,2,0,1]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 只包含字符 "I" 或 "D"
//
// Related Topics 贪心 数组 双指针 字符串 👍 406 👎 0
public class DiStringMatch {

    public static void main(String[] args) {
        DiStringMatch dm = new DiStringMatch();
        System.out.println(Arrays.toString(dm.diStringMatch("IDID")));
    }

    public int[] diStringMatch(String s) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.add(index);
        index++;
        List<Integer> list = new ArrayList<>();
        for(Character c : s.toCharArray()){
            if(c == 'D'){
                list.add(index);
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
            }else{
                stack.add(index);
            }
            index++;
        }
        list.add(index);
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        int [] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int[] diStringMatch2(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int low = 0;
        int high = n;
        for (int i = 0;i < n;i++){
            ans[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        ans[n] = high;
        return ans;
    }
}
