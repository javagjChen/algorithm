package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 1346.检查整数及其两倍数是否存在 简单
 * @Date 2022/6/8
 */
//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
//
// 更正式地，检查是否存在两个下标 i 和 j 满足：
//
//
// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]
//
//
//
//
// 示例 1：
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
//
//
// 示例 2：
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
//
//
// 示例 3：
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 500
// -10^3 <= arr[i] <= 10^3
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 58 👎 0
public class CheckIfExist {
    public static void main(String[] args) {
        CheckIfExist cie = new CheckIfExist();
        System.out.println(cie.checkIfExist(new int[]{7,1,14,11}));
    }
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0;i < len - 1; i++){
            int base = arr[i];
            int l = i;
            int r = len;
            while ( l + 1 != r){
                int mid = l + (r - l)/2;
                // 正数
                if (base >= 0){
                    if (arr[mid] < base *2){
                        l = mid;
                    }else if (arr[mid] > base *2){
                        r = mid;
                    }else {
                        return true;
                    }
                }else {
                    //负数
                    int t = arr[mid] * 2;
                    if (t < base){
                        l = mid;
                    }else if (t > base){
                        r = mid;
                    }else {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
