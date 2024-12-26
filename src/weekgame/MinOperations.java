package weekgame;

public class MinOperations {
    public int n;
    public int minOperations(int[] nums1, int[] nums2) {
        int max11 = 0;
        int max21 = 0;
        this.n = nums1.length;
        for (int i = 0;i < n;i++){
            if (nums1[i] > max11){

                max11 = nums1[i];
            }
            if (nums2[i] > max21){

                max21 = nums2[i];
            }
        }
        if (check(nums1,nums2,max11,max21)){
            return 0;
        }
        int ans = 1;
        int index = n -1;
        while (index >= 0){
            if (nums1[index] != nums2[index]) {
                int t1 = nums1[index];
                int t2 = nums2[index];
                nums1[index] = t2;
                nums2[index] = t1;
                int max1 = getMax(nums1);
                int max2 = getMax(nums2);
                if (check(nums1, nums2, max1, max2)) {
                    return ans;
                }
                ans++;

            }
            index--;
        }
        return -1;
    }

    public boolean check(int[] nums1, int[] nums2,int max1,int max2){
        return nums1[n - 1 ] == max1 && nums2[n - 1] == max2;
    }

    public int getMax(int[] nums){
        int max = 0;
        for (int i = 0;i < n;i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}
