package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chengj
 * @Description 658.找到 K 个最接近的元素 中等
 * @Date 2022/6/14
 */
//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
// 整数 a 比整数 b 更接近 x 需要满足：
//
//
// |a - x| < |b - x| 或者
// |a - x| == |b - x| 且 a < b
//
//
//
//
// 示例 1：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
//
//
//
//
// 提示：
//
//
// 1 <= k <= arr.length
// 1 <= arr.length <= 10⁴
// arr 按 升序 排列
// -10⁴ <= arr[i], x <= 10⁴
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 328 👎 0
public class FindClosestElements {

    public static void main(String[] args) {
        FindClosestElements fce = new FindClosestElements();
        int[] arr = new int[]{-2,-1,1,2,3,4,5};
        int k = 7;
        int x = 3;
        System.out.println(fce.findClosestElements(arr,k,x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>(k);
        int len = arr.length;
        // 先用蓝红二分找到最接近x的数
        int l = -1;
        int r = len;
        while (l +1 != r){
            int mid = l +(r - l)/2;
            if (arr[mid] <= x){
                l = mid;
            }else {
                r = mid;
            }
        }
        // 说明arr中的数都比x大
        if (l == -1){
            for (int i = 0; i<k;i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        // 说明arr中的数都比x小
        if (l == len){
            for (int i = len -k; i < len;i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        // 比较l 和 l +1
        if (l != len -1 && Math.abs(arr[l] - x) > Math.abs(arr[l + 1] - x)){
            l = l + 1;
        }
        ans.add(arr[l]);
        k--;
        // 再用双指针，获取结果
        int left = l - 1;
        int right = l + 1;

        while (k > 0 && left >=0 && right < len){
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                ans.add(arr[left]);
                left--;
            }else{
                ans.add(arr[right]);
                right++;
            }
            k--;
        }
        while (k > 0 && right == len){
            ans.add(arr[left]);
            left--;
            k--;
        }
        while (k > 0 && left == -1){
            ans.add(arr[right]);
            right++;
            k--;
        }
        Collections.sort(ans);
        return ans;
    }
}
