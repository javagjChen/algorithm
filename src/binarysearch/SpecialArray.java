package binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author chengj
 * @Description 1608.特殊数组的特征值 简单
 * @Date 2022/6/7
 */
//给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而
// x 是该数组的 特征值 。
//
// 注意： x 不必 是 nums 的中的元素。
//
// 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的
// 。
//
//
//
// 示例 1：
//
// 输入：nums = [3,5]
//输出：2
//解释：有 2 个元素（3 和 5）大于或等于 2 。
//
//
// 示例 2：
//
// 输入：nums = [0,0]
//输出：-1
//解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
//如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
//如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
//如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
//x 不能取更大的值，因为 nums 中只有两个元素。
//
// 示例 3：
//
// 输入：nums = [0,4,3,0,4]
//输出：3
//解释：有 3 个元素大于或等于 3 。
//
//
// 示例 4：
//
// 输入：nums = [3,6,7,7,0]
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
//
// Related Topics 数组 二分查找 排序 👍 65 👎 0
public class SpecialArray {

    public static void main(String[] args) {
        SpecialArray sa = new SpecialArray();
        System.out.println(sa.specialArray(new int[]{3,5}));
    }

    public int specialArray(int[] nums) {
        //左边蓝色区域 nums 中有 大于等于 x个元素 ≥x
        //右边红色区域 nums 中有 小于 x个元素 ≥x
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0;i < len/2;i++){
            int t = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = t;
        }
        int l = -1;
        int r = nums.length;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            //下标mid，共mid+1个元素，即前mid+1个元素 >= mid+1
            if (nums[mid] >= mid + 1){
                l = mid;
            }else {
                r = mid;
            }
        }
        // // x 不存在 或者 大于 x 个元素 大于或者等于 x
        if (l == -1 || (l + 1 != len && nums[l + 1] >= l + 1)){
            return -1;
        }
        // x数量为下标+1
        return l + 1;

    }

}
