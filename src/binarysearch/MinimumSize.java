package binarysearch;

/**
 * @author chengj
 * @Description 1760.袋子里最少数目的球 中等
 * @Date 2022/6/15
 */
//给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
//
// 你可以进行如下操作至多 maxOperations 次：
//
//
// 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
//
//
// 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
//
//
//
//
// 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
//
// 请你返回进行上述操作后的最小开销。
//
//
//
// 示例 1：
//
//
//输入：nums = [9], maxOperations = 2
//输出：3
//解释：
//- 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
//- 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
//装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
//
//
// 示例 2：
//
//
//输入：nums = [2,4,8,2], maxOperations = 4
//输出：2
//解释：
//- 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
//- 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
//- 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
//- 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
//装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
//
//
// 示例 3：
//
//
//输入：nums = [7,17], maxOperations = 2
//输出：7
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= maxOperations, nums[i] <= 10⁹
//
// Related Topics 数组 二分查找 👍 82 👎 0
public class MinimumSize {

    public static void main(String[] args) {
        MinimumSize ms = new MinimumSize();
        int[] nums = new int[]{805306368,805306368,805306368};
        int maxOperations = 1000000000;
        System.out.println(ms.minimumSize(nums,maxOperations));
    }

    /**
     * 蓝红二分查找，求 操作次数小于等于maxOperations 下的最大值
     * @param nums
     * @param maxOperations
     * @return
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 0;
        int r = 1000000000 + 1;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            if (checkCount(nums,mid) > maxOperations){
                l = mid;
            }else {
                r = mid;
            }
        }
        return r;
    }
    // 统计拆分次数
    private long checkCount(int[] nums, int mid) {
        long count = 0;
        for (int val : nums){
            // 袋子里的球大于 目标x时才需要拆分
            if (val > mid){
                count += (val%mid == 0 ? val/mid - 1 : val/mid);
            }
        }
        return count;
    }
}
