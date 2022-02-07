package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/23
 */
public class BubblingSort {
    public static void main(String[] args) {
        int [] nums = new int[]{9,3,-3,-20,20,10};
        bollSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void  bollSort(int [] nums){
        int temp;
        for (int i =0;i < nums.length -1;i++){
            for (int j =0 ;j < nums.length -1 -i;j++){
                if (nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

    }
}
