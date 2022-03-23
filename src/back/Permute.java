package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 46.全排列 中等
 * @Author chengj
 * @Date 2022/1/19
 */

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 1757 👎 0
public class Permute {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    /**
     * 利用回溯算法
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1){
            return result;
        }
        int len = nums.length;
        boolean [] used = new boolean[len];
        List<Integer> subList = new ArrayList<>();
        dpf(nums,len,0,subList,used,result);
        return result;
    }

    public static void dpf(int[] nums, int len, int deep, List<Integer> subList,boolean [] used, List<List<Integer>> result) {
        if (deep == len){
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0;i < len;i++){
            if (!used[i]){
                subList.add(nums[i]);
                used[i] = true;
                dpf(nums,len,deep+1,subList,used,result);
                used[i] = false;
                subList.remove(deep);
            }

        }
    }
}
