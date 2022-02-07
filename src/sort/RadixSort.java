package sort;

import java.util.Arrays;

/**
 * @Description
 * @Author chengj
 * @Date 2021/12/1
 */
public class RadixSort {
    public static void main(String[] args) {
        int [] arr = new int[]{ 123,5,247,51};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        // 51,123,5,247

    }

    public static void radixSort(int [] arr){
        int length = arr.length;
        //定义十个桶
        int [] [] buckets = new int[10][length];
        //定义桶的实际容量
        int [] bucketCapacity = new int[10];
        //最大数
        int max = arr[0];
        for (int m = 1;m < arr.length;m++){
            if (arr[m] > max){
                max = arr[m];
            }
        }
        // 最大数的位数
        int maxLen = (max + "").length();

        for (int r = 1,n =1 ; r<= maxLen;r++,n*=10){
            //数组放到桶里
            for (int i = 0; i < length; i++){
                // 桶的位置
                int temp = arr[i] /n % 10;
                buckets[temp][bucketCapacity[temp]] = arr[i];
                //桶的容量加1
                bucketCapacity[temp]++;
            }
            // 桶里的数重新放回原数组
            int index = 0;
            for (int j = 0;j< buckets.length;j++){
                // 桶里有元素才放
                if (bucketCapacity[j] != 0){
                    for (int k =0;k < bucketCapacity[j];k++){
                        arr[index] = buckets[j][k];
                        index++;
                    }
                    // 置零
                    bucketCapacity[j] = 0;
                }
            }

            System.out.println("第"+r+"次:" + Arrays.toString(arr));
        }

    }
}
