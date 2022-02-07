package stringandarr;

/**
 * @Description 删除有序数组中的重复项
 * @Author chengj
 * @Date 2022/1/17
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1){
            return 0;
        }
        int slow = 1,fast = 1;
        while (fast < nums.length){
            if (nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
