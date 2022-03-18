package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengj
 * @Description 39.组合总和 中等
 * @Date 2022/2/10
 */
//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
//
//
//
// 示例 1：
//
//
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。
//
// 示例 2：
//
//
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3：
//
//
//输入: candidates = [2], target = 1
//输出: []
//
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都 互不相同
// 1 <= target <= 500
//
// Related Topics 数组 回溯 👍 1743 👎 0
public class CombinationSum {

    /**
     * 回溯
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfp(ans,candidates,combine,target,0);
        return ans;
    }

    private void dfp(List<List<Integer>> ans, int[] candidates, List<Integer> combine, int target, int index) {
        if (index == candidates.length){
            return;
        }
        if (target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfp(ans,candidates,combine,target,index +1);
        if (target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfp(ans,candidates,combine,target - candidates[index],index);
            combine.remove(candidates[index]);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int index) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(res, path, candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}
