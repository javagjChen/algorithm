package binarysearch;

/**
 * @author chengj
 * @Description 1712.将数组分成三个子数组的方案数 中等
 * @Date 2022/6/24
 */
//我们称一个分割整数数组的方案是 好的 ，当它满足：
//
//
// 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
// left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
//
//
// 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1]
//输出：1
//解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,2,2,5,0]
//输出：3
//解释：nums 总共有 3 种好的分割方案：
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
//
//
// 示例 3：
//
//
//输入：nums = [3,2,1]
//输出：0
//解释：没有好的分割方案。
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁴
//
// Related Topics 数组 双指针 二分查找 前缀和 👍 75 👎 0
public class WaysToSplit {

    public static void main(String[] args) {
        WaysToSplit wts = new WaysToSplit();
        System.out.println(wts.waysToSplit(new int[]{1,1,1}));
    }

    private int mod = (int) 1e9 + 7;
    public int waysToSplit(int[] nums) {
        int len = nums.length;
        // 前序和
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len;i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < len -2;i++){
            // 先找到 minJ ,即 sumLeft <= sumMid 中 sumMid最小值对应的下标 j
            // j 的范围 [i+1,len-2]
            int l = i;
            int r = len - 1;
            while (l + 1 != r){
                int mid = l + (r - l)/2;
                if (preSum[i + 1] > preSum[mid + 1] - preSum[i + 1]){
                    l = mid;
                }else {
                    r = mid;
                }
            }
            int miniJ = r;
            // 再找到 maxJ ,即 sumRight >= sumMid 中 sumMid最大值对应的小标 j
            l = i;
            r = len - 1;
            while (l + 1 != r){
                int mid = l + (r - l)/2;
                if (preSum[mid + 1] - preSum[i + 1] <= preSum[len] - preSum[mid + 1] ){
                    l = mid;
                }else {
                    r = mid;
                }
            }
            int maxJ = l;
            if (maxJ < miniJ){
                continue;
            }
            ans += (maxJ - miniJ + 1);
            ans = ans % mod;
        }
        return ans;
    }

}
