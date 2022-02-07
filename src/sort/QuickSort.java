package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/26
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] nums = new int[]{-9,78,0,23,-567,70};
//        int [] nums = new int[]{3,0,0};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int [] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(l + r)/2];

        int temp;
        while (l < r){
            //找到比中轴大的
            while (arr[l] < pivot){
                l++;
            }
            //找到比中轴小的
            while (arr[r] > pivot){
                r--;
            }
            //说明中轴左边的都比中轴小，中轴右边的都比中轴大
            if (l >=r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //
            if (arr[l] == pivot){
                r--;
            }
            if (arr[r] == pivot){
                l++;
            }

        }

        if (l == r){
            l++;
            r--;
        }
        if (left < r){
            quickSort(arr,left,r);
        }

        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
