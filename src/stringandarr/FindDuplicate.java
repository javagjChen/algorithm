package stringandarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 寻找重复数
 * @Author chengj
 * @Date 2022/1/11
 */
public class FindDuplicate {

    public static void main(String[] args) {

    }

    /**
     * 寻找重复数 不符合规则的解法
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i], i);
        }
        return 0;
    }

    /**
     * 寻找重复数
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
