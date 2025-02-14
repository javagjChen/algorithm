package partice;

import java.util.*;

/**
 * @author chengj
 * @Description 967.连续差相同的数字 中等
 * @Date 2022/8/30
 */
//返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
//
// 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 3, k = 7
//输出：[181,292,707,818,929]
//解释：注意，070 不是一个有效的数字，因为它有前导零。
//
//
// 示例 2：
//
//
//输入：n = 2, k = 1
//输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
//
// 示例 3：
//
//
//输入：n = 2, k = 0
//输出：[11,22,33,44,55,66,77,88,99]
//
//
// 示例 4：
//
//
//输入：n = 2, k = 2
//输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
//
//
//
//
// 提示：
//
//
// 2 <= n <= 9
// 0 <= k <= 9
//
// Related Topics 广度优先搜索 回溯 👍 80 👎 0
public class NumsSameConsecDiff {

    public static void main(String[] args) {
        NumsSameConsecDiff nscd = new NumsSameConsecDiff();
        System.out.println(Arrays.toString(nscd.numsSameConsecDiff(2,1)));

    }

    List<Integer> list = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {

        for (int i = 1;i <=9;i++){
            // 过滤不在范围内的
            if (i + k > 9 && i - k < 0){
                continue;
            }
            dps(1,n,new StringBuilder().append(i),k);
        }
        int[] ans = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }


    public void dps(int index,int n,StringBuilder sb,int k){
        //长度到了就进入结果
        if (index == n){
            int t = Integer.parseInt(sb.toString());
            list.add(t);
            return;
        }
        // 获取上一个数字是什么
        int num = sb.charAt(sb.length() - 1) - '0';
        if (num + k < 10){
            sb.append(num + k);
            dps(index + 1,n,sb,k);
            sb.deleteCharAt(index);
        }
        if (k != 0 && num - k >=0){
            sb.append(num - k);
            dps(index+ 1,n,sb,k);
            sb.deleteCharAt(index);
        }

    }
}
