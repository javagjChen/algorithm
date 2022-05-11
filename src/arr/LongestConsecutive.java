package arr;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chengj
 * @Description 128.最长连续序列 中等
 * @Date 2022/5/9
 */
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
// Related Topics 并查集 数组 哈希表 👍 1249 👎 0
public class LongestConsecutive {

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        System.out.println(lc.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    // 100,4,200,1,3,2
    public int longestConsecutive(int[] nums) {
        // 重复的不需要考虑
        Set<Integer> set = new HashSet<>();
        for (int val : nums){
            set.add(val);
        }
        //最终结果
        int ans = 0;
        //
        for (int num : nums){
            // 存在就跳过
            if (!set.contains(num-1)){
                // 从num开始连续
                int tmp = 0;
                int tmpNum = num;
                while (set.contains(tmpNum)){
                    tmp++;
                    tmpNum++;
                }
                ans = Math.max(ans,tmp);
            }
        }

        return ans;
    }
}
