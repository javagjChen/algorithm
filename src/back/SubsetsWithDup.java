package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengj
 * @Description 90.子集2 中等
 * @Date 2022/3/21
 */
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
//
// Related Topics 位运算 数组 回溯 👍 770 👎 0
public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{1,2,2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        doSubsetsWithDup(ans,list,nums,0);
        return ans;
    }

    private void doSubsetsWithDup(List<List<Integer>> ans, List<Integer> list, int[] nums, int index) {

        ans.add(new ArrayList<>(list));

        for (int i = index;i < nums.length;i++){
            if (i > index && nums[i-1] == nums[i]){
                continue;
            }
            list.add(nums[i]);
            doSubsetsWithDup(ans,list,nums,i + 1);
            list.remove(list.size() - 1);
        }

    }
}
