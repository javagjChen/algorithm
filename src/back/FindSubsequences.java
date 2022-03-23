package back;

import java.util.*;
/**
 * @author chengj
 * @Description 491.递增子序列 中等
 * @Date 2022/3/15
 */
//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
//
//
// 示例 2：
//
//
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 15
// -100 <= nums[i] <= 100
//
// Related Topics 位运算 数组 哈希表 回溯 👍 404 👎 0
public class FindSubsequences {
    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        System.out.println(findSubsequences.findSubsequences(new int[]{4,6,7,7}).toString());
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        doFindSubsequences(ans,list,nums,0);
        return ans;
    }

    private void doFindSubsequences(List<List<Integer>> ans, Deque<Integer> list, int[] nums, int index) {
        if (list.size() > 1){
            ans.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index;i<nums.length;i++){
            if ((!list.isEmpty()&& nums[i] < list.peekLast())|| set.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);
            doFindSubsequences(ans,list,nums,i +1);
            list.removeLast();
        }
    }
}
