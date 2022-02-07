package math;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//
// 0 <= a, b, c, d < n
// a、b、c 和 d 互不相同
// nums[a] + nums[b] + nums[c] + nums[d] == target
//
//
// 你可以按 任意顺序 返回答案 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 双指针 排序 👍 1083 👎 0

/**
 * @Description 四数之和
 * @Author chengj
 * @Date 2022/1/18
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 4){
            return result;
        }
        // 先排序
        Arrays.sort(nums);

        for (int i = 0;i < len-3;i++){
            // 重复，则进入下一个循环
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 因为是升序排列，后面的数只会更大
            if ((long)nums[i] + nums[i+1] + nums[i +2] + nums[i+3] > target){
                break;
            }
            // 小于目标，进入下一个循环
            if ((long)nums[i] + nums[len -3] + nums[len -2] + nums[len -1] < target){
                continue;
            }
            for (int j = i + 1; j < len -2;j++){
                // 重复，则进入下一个循环
                if (j > i +1 && nums[j] == nums[j -1]){
                    continue;
                }
                // 因为是升序排列，后面的数只会更大
                if ((long)nums[i] + nums[j] + nums[j+1] + nums[j +2] > target){
                    break;
                }
                // 小于目标，进入下一个循环
                if ((long)nums[i] + nums[j] + nums[len -2] + nums[len -1] < target){
                    continue;
                }

                int left = j +1;
                int right = len -1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[left]);
                        subList.add(nums[right]);
                        result.add(subList);
                        while (left < right-1 && nums[right] == nums[right -1]){
                            right--;
                        }
                        right--;
                        while (left +1 < right && nums[left] == nums[left +1]){
                            left++;
                        }
                        left++;
                    }else if (sum> target){
                        while (left < right-1 && nums[right] == nums[right -1]){
                            right--;
                        }
                        right--;
                    }else {
                        while (left +1 < right && nums[left] == nums[left +1]){
                            left++;
                        }
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
