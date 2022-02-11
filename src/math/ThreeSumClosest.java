package math;

import java.util.Arrays;

/**
 * @Description 最接近的三数之和 中等
 * @Author chengj
 * @Date 2022/1/14
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        // target的最大值
        int best = 10000;
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0;i < len;i++){
            // 小优化 相同的值就重复了
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target){
                    return sum;
                }
                // 更新最接近的数
                if (Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if (sum > target){
                    // 右指针左移
                    int right1 = right - 1;
                    while (right1 > left && nums[right] == nums[right1]){
                        right1--;
                    }
                    right = right1;
                }else {
                    // 左指针右移
                    int left1 = left +1;
                    while (left1 < right && nums[left1] == nums[left]){
                        left1++;
                    }
                    left = left1;
                }
            }

        }
        return best;
    }
}
