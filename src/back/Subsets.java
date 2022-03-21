package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 78.子集 中等
 * @Date 2022/3/17
 */
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯 👍 1525 👎 0
public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}).toString());
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        doSubSets(ans,list,0,nums);
        return ans;
    }

    private void doSubSets(List<List<Integer>> ans,List<Integer> list,int index, int[] nums){


        List<Integer> tmp = new ArrayList<>(list);
        ans.add(tmp);

        for (int i =index;i<nums.length;i++){
            list.add(nums[i]);
            doSubSets(ans,list,i+1,nums);
            list.remove(list.size() -1);
        }
    }
}
