package weekgame;

import java.util.*;

/**
 * @author chengj
 * @Description 6164.数位和相等数对的最大和
 * @Date 2022/7/17
 */
//给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与
//nums[j] 的数位和相等。
//
// 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [18,43,36,13,7]
//输出：54
//解释：满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。
//
// 示例 2：
//
//
//输入：nums = [10,12,19,14]
//输出：-1
//解释：不存在满足条件的数对，返回 -1 。
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
// 👍 5 👎 0
public class MaximumSum {

    public static void main(String[] args) {
        MaximumSum ms = new MaximumSum();
        int[] nums = new int[]{229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401};
        System.out.println(ms.maximumSum(nums));
    }
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int val :nums){
            int t = getSum(val);
            if (map.containsKey(t)){
                List<Integer> list = map.get(t);
                list.add(val);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(val);
                map.put(t,list);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> value = entry.getValue();
            if (value.size() == 1){
                continue;
            }
            Collections.sort(value,Comparator.reverseOrder());

            ans = Math.max(ans, value.get(0) + value.get(1));
        }
        return ans == 0? -1:ans;
    }

    public int getSum(int val){
        int ans = 0;
        while (val >0){
            ans += val%10;
            val /= 10;
        }
        return ans;
    }
}
