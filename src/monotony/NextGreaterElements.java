package monotony;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author chengj
 * @Description 503.下一个更大元素2 中等
 * @Date 2022/4/25
 */
//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
//。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数；
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
//
//
// 示例 2:
//
//
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
// Related Topics 栈 数组 单调栈 👍 602 👎 0
public class NextGreaterElements {
    public static void main(String[] args) {
        NextGreaterElements nge = new NextGreaterElements();
        int[] nums = new int[]{1,2,3,4,3};
        System.out.println(Arrays.toString(nge.nextGreaterElements(nums)));
    }
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        for (int i = 0;i < len;i++){
            for (int j = i + 1; j < i+len;j++){
                if (nums[j%len] > nums[i]){
                    ans[i] = nums[j%len];
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 单调栈解法
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1;i < len *2;i++){
            while (!stack.isEmpty() && nums[i%len] > nums[stack.peek()]){
                ans[stack.peek()] = nums[i%len];
                stack.pop();
            }
            stack.push(i%len);
        }
        return ans;
    }
}
