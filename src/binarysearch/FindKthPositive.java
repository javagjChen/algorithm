package binarysearch;

/**
 * @author chengj
 * @Description 1539.第 K 个缺失的正整数 简单
 * @Date 2022/6/7
 */
//给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
//
// 请你找到这个数组里第 k 个缺失的正整数。
//
//
//
// 示例 1：
//
//
//输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
//
//
// 示例 2：
//
//
//输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000
// 1 <= k <= 1000
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
//
//
//
//
// 进阶：
//
// 你可以设计一个时间复杂度小于 O(n) 的算法解决此问题吗？
// Related Topics 数组 二分查找 👍 114 👎 0
public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        // 如果数组第一个数缺失的数量大于等于k
        // 则这k个数都在前面
        if (missingCount(arr,0) >= k){
            return k;
        }
        int len = arr.length;
        int l = -1;
        int r = len;
        // 左边蓝色区域为数组中缺失元素个数小于k的区间，
        // 右边红色区域为数组中缺失元素个数大于或等于k的区间
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            if (missingCount(arr,mid) < k){
                l = mid;
            }else {
                r = mid;
            }
        }
        // 这里l 是最后一个缺失元素个数小于k的
        // arr[i] - i - 1表示arr[i]位置缺少的元素个数，
        // k - 缺失个数 表示从arr[l]开始还缺少几个元素，
        // 再加上arr[l]，就是第k个缺失的元素
        return k - missingCount(arr,l) + arr[l];
    }

    // index 下标 缺失的正整数数量
    private int missingCount(int[] arr,int index){
        return arr[index] - index -1;
    }
}
