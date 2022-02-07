package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author chengj
 * @Date 2021/12/1
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] nums = new int[]{9,3,-3,-20,20,10};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int [] arr,int L,int R){
        if (L == R){
            return;
        }
        int M = L + ((R - L) >> 1);
        mergeSort(arr,L,M);
        mergeSort(arr,M + 1,R);
        merge(arr,L,M,R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int [] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length;j++){
            arr[L + j] = help[j];
        }
    }
}
