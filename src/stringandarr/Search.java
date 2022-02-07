package stringandarr;

/**
 * @Description 搜索旋转排序数组
 * @Author chengj
 * @Date 2022/1/17
 */
public class Search {

    /**
     * 二分法 二分之后一定有一部分是有序的
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return -1;
        }
        if (len ==1){
            return nums[0] == target? 0:-1;
        }
        int l = 0;
        int r = len -1;
        while (l <= r){
            int mid = l + ((r -l)>>2);
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid -1;
                }else {
                    l = mid +1;
                }
            }else {
                if (nums[mid] < target && nums[len -1] >= target){
                    l = mid +1;
                }else {
                    r = mid -1;
                }
            }
        }
        return -1;
    }
}
