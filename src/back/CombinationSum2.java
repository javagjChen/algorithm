package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengj
 * @Description 组合总和2 中等
 * @Date 2022/2/10
 */
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
// Related Topics 数组 回溯 👍 824 👎 0
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        // 先排序
        Arrays.sort(candidates);
        dfp(ans,candidates,target,combine,0);
        return ans;
    }

    private void dfp(List<List<Integer>> ans, int[] candidates, int target, List<Integer> combine, int begin) {

        if (target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i  = begin; i < candidates.length; i++) {
            //
            if (candidates[i] > target) {
                break;
            }
            // 相同的
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combine.add(candidates[i]);
            dfp(ans, candidates, target - candidates[i],combine,i +1);
            combine.remove(combine.size() -1);
        }

    }
}
