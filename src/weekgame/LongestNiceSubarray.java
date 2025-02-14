package weekgame;

/**
 * @author chengj
 * @Description 2401.最长优雅子数组 中等
 * 第 309 场周赛 第3题
 * @Date 2022/9/4
 */
//给你一个由 正 整数组成的数组 nums 。
//
// 如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。
//
// 返回 最长 的优雅子数组的长度。
//
// 子数组 是数组中的一个 连续 部分。
//
// 注意：长度为 1 的子数组始终视作优雅子数组。
//
//
//
// 示例 1：
//
// 输入：nums = [1,3,8,48,10]
//输出：3
//解释：最长的优雅子数组是 [3,8,48] 。子数组满足题目条件：
//- 3 AND 8 = 0
//- 3 AND 48 = 0
//- 8 AND 48 = 0
//可以证明不存在更长的优雅子数组，所以返回 3 。
//
// 示例 2：
//
// 输入：nums = [3,1,5,11,13]
//输出：1
//解释：最长的优雅子数组长度为 1 ，任何长度为 1 的子数组都满足题目条件。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
// 👍 8 👎 0
public class LongestNiceSubarray {


    public static void main(String[] args) {
        LongestNiceSubarray lns = new LongestNiceSubarray();
        int[] nums = new int[]{178830999,19325904,844110858,806734874,280746028,64,256,33554432,882197187,104359873,453049214,820924081,624788281,710612132,839991691};
        //int[]nums = new int[]{1,3,8,48,10};
        System.out.println(lns.longestNiceSubarray(nums));
    }

    //第 309 场周赛 第3题
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 1;

        for (int i = 0;i < n;i++){
            int t = nums[i];
            for (int j = i + 1; j < n;j++){
                if ((t & nums[j]) == 0){
                    maxLen = Math.max(maxLen,j - i +1);
                    //相当于把前面的比较过的结果放到t ，让其和下一个nums[j]比较
                    t |= nums[j];

                }else{
                    break;
                }
            }
        }
        return maxLen;
    }


}
