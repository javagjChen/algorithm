package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/23
 */
public class SelectSort {

    public static void main(String[] args) {
        int [] nums = new int[]{9,3,-3,-20,20,10};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int [] arr){

        for (int i = 0; i < arr.length -1;i++){
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1;j < arr.length;j++){
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
