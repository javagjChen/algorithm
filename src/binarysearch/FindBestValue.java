package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 1300.转变数组后最接近目标值的数组和 中等
 * @Date 2022/6/30
 */
//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和
//最接近 target （最接近表示两者之差的绝对值最小）。
//
// 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
//
// 请注意，答案不一定是 arr 中的数字。
//
//
//
// 示例 1：
//
// 输入：arr = [4,9,3], target = 10
//输出：3
//解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
//
//
// 示例 2：
//
// 输入：arr = [2,3,5], target = 10
//输出：5
//
//
// 示例 3：
//
// 输入：arr = [60864,25176,27249,21296,20204], target = 56803
//输出：11361
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^4
// 1 <= arr[i], target <= 10^5
//
// Related Topics 数组 二分查找 排序 👍 170 👎 0
public class FindBestValue {

    public static void main(String[] args) {
        FindBestValue fbv = new FindBestValue();
        int[] arr = new int[]{2,3,5};
        int target = 11;
        System.out.println(fbv.findBestValue(arr,target));
    }

    public int findBestValue(int[] arr, int target) {

        int max = arr[0];
        for(int val : arr){
            if(val > max){
                max = val;
            }
        }
        Arrays.sort(arr);
        int l = 0;
        int r = max + 1;
        while(l + 1 != r){
            int mid = l + (r - l)/2;
            if(getTotal(arr,mid) < target){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(Math.abs(getTotal(arr,l) - target) <= Math.abs(getTotal(arr,r) - target)){
            return l;
        }
        return r;

    }

    public int getTotal(int[] arr,int target){
        int l = -1;
        int r = arr.length;
        while (l + 1 != r){
            int mid = l + (r-l)/2;
            if(arr[mid] < target){
                l = mid;
            }else{
                r = mid;
            }
        }

        int sum = 0;
        for(int i = 0;i < r;i++){
            sum += arr[i];
        }
        if(r != arr.length){
            sum = sum + (arr.length - r)*target;
        }
        return sum;
    }
}
