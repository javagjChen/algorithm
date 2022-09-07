package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/3
 */
public class FindSubarrays {

    public static void main(String[] args) {
        FindSubarrays fs = new FindSubarrays();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(fs.findSubarrays(nums));
    }
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        if (n == 2){
            return false;
        }
        if (n == 3){
            return nums[0] + nums[1] == nums[1] + nums[2];
        }
        for (int i = 0;i < n - 3;i++){
            for (int j = i+1;j < n -1;j++){
                if (nums[i] + nums[i+1] == nums[j] + nums[j+1]){
                    return true;
                }
            }
        }
        return false;
    }
}
