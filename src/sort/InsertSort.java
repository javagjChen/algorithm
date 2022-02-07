package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/23
 */
public class InsertSort {

    public static void main(String[] args) {
        int [] nums = new int[]{9,3,-3,-20,20,10};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int [] arr){

        for (int i = 1;i < arr.length;i++){
            int insert = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && insert < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            arr[insertIndex + 1] = insert;
        }

    }
}
