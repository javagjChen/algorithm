package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 47.全排列2 中等
 * @Author chengj
 * @Date 2022/1/20
 */

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯 👍 935 👎 0
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1){
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> subList = new ArrayList<>();
        boolean [] used = new boolean[len];
        dfp(nums,len,0,used,subList,result);
        return result;
    }

    private void dfp(int[] nums, int len, int deep,boolean [] used, List<Integer> subList, List<List<Integer>> result) {
        if (deep == len){
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0;i < len;i++){
            if (used[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i -1]){
                continue;
            }
            subList.add(nums[i]);
            used[i] = true;
            dfp(nums,len,deep +1,used,subList,result);
            used[i] = false;
            subList.remove(deep);
        }
    }
}
