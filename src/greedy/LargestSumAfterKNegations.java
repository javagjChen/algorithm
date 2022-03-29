package greedy;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 1005.K 次取反后最大化的数组合 简单
 * @Date 2022/3/28
 */
//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
//
//
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
//
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
//
// 以这种方式修改数组后，返回数组 可能的最大和 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
//
//
// 示例 3：
//
//
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -100 <= nums[i] <= 100
// 1 <= k <= 10⁴
//
// Related Topics 贪心 数组 排序 👍 225 👎 0
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        for(int i =0; i < nums.length;i++){
            sum += nums[i];
        }
        while(k > 0){
            k--;
            int min  = getMin(nums);
            if (min < 0){
                sum += (0 - min) * 2;
            }else{
                sum -= min*2;
            }
        }
        return sum;
    }

    public int getMin(int[] nums){
        Arrays.sort(nums);
        int min = nums[0];
        nums[0] = 0 - min;
        return min;
    }

    /**
     * 优化解法
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations2(int[] nums, int k) {
        // 1、先排序
        Arrays.sort(nums);
        // 2、将负数尽可能多的翻转为正数
        for (int i = 0;i < nums.length;i++){
            if (nums[i] < 0 && k > 0){
                k--;
                nums[i] = 0 - nums[i];
            }
        }
        // 3、再排序
        Arrays.sort(nums);
        // 4、判断剩余翻转次数是否为奇数, 如果是奇数则将第一个元素翻转(最小正数变负数, 对最终结果影响最"小")
        if (nums[0] != 0 && k%2==1){
            nums[0] = 0 - nums[0];
        }
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        return sum;
    }
}
