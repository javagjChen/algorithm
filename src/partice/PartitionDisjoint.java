package partice;

/**
 * @author chengj
 * @Description 915.分割数组 中等
 * @Date 2022/9/13
 */
//给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
//
//
// left 中的每个元素都小于或等于 right 中的每个元素。
// left 和 right 都是非空的。
// left 的长度要尽可能小。
//
//
// 在完成这样的分组后返回 left 的 长度 。
//
// 用例可以保证存在这样的划分方法。
//
//
//
// 示例 1：
//
//
//输入：nums = [5,0,3,8,6]
//输出：3
//解释：left = [5,0,3]，right = [8,6]
//
//
// 示例 2：
//
//
//输入：nums = [1,1,1,0,6,12]
//输出：4
//解释：left = [1,1,1,0]，right = [6,12]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁶
// 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
//
// Related Topics 数组 👍 106 👎 0
public class PartitionDisjoint {

    public static void main(String[] args) {
        PartitionDisjoint pd = new PartitionDisjoint();
        int[] nums = new int[]{1,1};
        System.out.println(pd.partitionDisjoint(nums));
    }

    public int partitionDisjoint(int[] nums) {

        int max = nums[0];
        while(true){
            for(int i = 0;i < nums.length - 1;i++){
                if(max < nums[i]){
                    max = nums[i];
                }
                boolean flag = true;
                for(int j = i + 1; j < nums.length;j++){
                    if(nums[j] < max){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    return i + 1;
                }
            }
        }
    }
    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        // [0, i]的最大值
        int max = nums[0];
        // [0, pos]的最大值 也就是它是左边阵营的最大值
        int leftMax = nums[0];
        // 分界点
        int pos = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            // 如果当前元素小于还小于左边阵营的最大值，那当前元素可以收归麾下
            if (nums[i] < leftMax) {
                // 将当前阵地范围扩大并重新计算最大值（因为右边阵营的所有值都会大于左边阵营的所有值）
                leftMax = max;
                pos = i;
            }
        }
        return pos + 1;
    }
}
