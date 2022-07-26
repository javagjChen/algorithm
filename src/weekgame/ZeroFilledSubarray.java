package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/23
 */
public class ZeroFilledSubarray {
    public static void main(String[] args) {
        ZeroFilledSubarray zfs = new ZeroFilledSubarray();
        int[] nums = new int[]{2,10,2019};
        System.out.println(zfs.zeroFilledSubarray(nums));
    }



    public long zeroFilledSubarray(int[] nums) {
        int end = 0;
        long ans = 0;
        int len = 0;
        while (end < nums.length){
            if (nums[end] != 0) {
                if (len != 0){
                    ans += getSum(len);
                    len = 0;
                }
            }else {
                len++;
            }
            end++;
        }
        if (len != 0){
            ans += getSum(len);
        }
        return ans;
    }

    public long getSum(int len){
        return (long)(len + 1) * len / 2;
    }
}
