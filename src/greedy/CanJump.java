package greedy;

/**
 * @author chengj
 * @Description 55.跳跃游戏 中等
 * @Date 2022/2/17
 */
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// 0 <= nums[i] <= 10⁵
//
// Related Topics 贪心 数组 动态规划 👍 1643 👎 0
public class CanJump {
    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump2(new int[]{3,2,1,0,4}));
    }

    /**
     * 贪心的解法
     * 这里需要注意的是到n-2就可以了
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return true;
        }
        int  maxLength = nums[0];
        for (int i =1;i < len-1;i++){
            if (maxLength < 1){
                return false;
            }
            maxLength = Math.max(maxLength -1,nums[i]);
        }
        return maxLength >= 1;
    }

    public boolean canJump2(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return true;
        }
        int  maxLength = 0;
        for (int i =0;i <= maxLength;i++){
            maxLength = Math.max(maxLength,i+nums[i]);
            if (maxLength >= len-1){
                return true;
            }
        }
        return false;
    }

}
