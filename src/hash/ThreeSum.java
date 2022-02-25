package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TransferQueue;

/**
 * @author chengj
 * @Description 三数之和 中等
 * @Date 2022/2/25
 */
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
// Related Topics 数组 双指针 排序 👍 4356 👎 0
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len;i++){
            if (i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    ans.add(tmp);
                    int left1 = left + 1;
                    while (left1 < right && nums[left1] == nums[left]){
                        left1++;
                    }
                    left = left1;
                    int right1 = right - 1;
                    while (right1 > left && nums[right1] == nums[right]){
                        right1--;
                    }
                    right = right1;
                }else if (sum > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return ans;
    }
}
