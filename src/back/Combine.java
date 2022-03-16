package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 组合 中等
 * @Date 2022/3/15
 */
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
// Related Topics 数组 回溯 👍 899 👎 0
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        doCombine(ans,subList,1,k,n);
        return ans;
    }

    private void doCombine(List<List<Integer>> ans,List<Integer> subList,
                           int index,int k,int n){
        if (index > n - (k - subList.size()) + 1){
            return;
        }
        if (subList.size() == k){
            List<Integer> list = new ArrayList<>(subList);
            ans.add(list);
            return;
        }
        for (int i = index; i <= n;i++){
            subList.add(i);
            doCombine(ans,subList,i + 1,k,n);
            subList.remove(subList.size() -1);
        }
    }
}
