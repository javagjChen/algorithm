package arr;

/**
 * @author chengj
 * @Description 非递减数列 中等
 * @Date 2022/2/17
 */
//给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
//
//
//
// 示例 1:
//
//
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
//
//
// 示例 2:
//
//
//输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
//
//
//
//
// 提示：
//
//
//
// n == nums.length
// 1 <= n <= 10⁴
// -10⁵ <= nums[i] <= 10⁵
//
// Related Topics 数组 👍 640 👎 0
public class CheckPossibility {
    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        System.out.println(checkPossibility.checkPossibility(new int[]{1,4,2,3}));
    }
    public boolean checkPossibility(int[] nums) {
        int ans = 0;
        for (int i = 1;i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                ans++;
                // 和前面的数比较
                if (i > 1 && nums[i] < nums[i -2]){
                    nums[i] = nums[i-1];
                }else {
                    nums[i -1] = nums[i];
                }
            }
        }
        return ans <= 1;
    }
}
