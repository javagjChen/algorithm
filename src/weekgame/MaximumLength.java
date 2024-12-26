package weekgame;

public class MaximumLength {
    public static void main(String[] args) {
        MaximumLength ml = new MaximumLength();
        int[] nums = new int[]{1,2,1,1,2,1,2};
        System.out.println(ml.maximumLength(nums));
    }
    public int maximumLength(int[] nums) {
        int n = nums.length;
        if (n == 2){
            return 2;
        }
        int ans = 0;
        for (int i = 0;i < n - 1;i++){
            int base = 1;
            int t = (nums[i] + nums[i + 1])%2;
            for (int j = i + 1;j < n - 1;j++){
                if (t == (nums[j] + nums[j + 1])%2){
                    base++;
                }
            }
            ans = Math.max(ans,base + 1);
        }
        return ans;
    }
}
