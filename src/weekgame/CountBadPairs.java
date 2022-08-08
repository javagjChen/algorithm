package weekgame;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description 6142. 统计坏数对的数目 中等
 * @Date 2022/8/6
 */
//给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一
//个 坏数对 。
//
// 请你返回 nums 中 坏数对 的总数目。
//
//
//
// 示例 1：
//
// 输入：nums = [4,1,3,3]
//输出：5
//解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
//数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
//数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
//数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
//数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
//总共有 5 个坏数对，所以我们返回 5 。
//
//
// 示例 2：
//
// 输入：nums = [1,2,3,4,5]
//输出：0
//解释：没有坏数对。
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
// 👍 6 👎 0
public class CountBadPairs {
    public static void main(String[] args) {
        CountBadPairs cbp = new CountBadPairs();
        int[] nums = new int[]{4,1,3,3};
        System.out.println(cbp.countBadPairs(nums));
    }
    public long countBadPairs(int[] nums) {
        /**
          ** 逆向思维+HashMap
          ** 由 j - i != nums[j] - nums[i] 得到 j - nums[j] != i - nums[i]
          ** 反过来可以求 j - nums[j] == i - nums[i] 的数目，这部分可以用HashMap预处理直接计算
          ** 最后再用总数减去上面的好数组即可
         */
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int t = nums[i] - i;
            map.put(t,map.getOrDefault(t,0) + 1);
        }

        long total = (long) n * (n-1)/2;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            total -= (long)val * (val -1) /2;
        }
        return total;
    }
}
