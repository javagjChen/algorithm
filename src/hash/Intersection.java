package hash;

import java.util.*;

/**
 * @author chengj
 * @Description 349.两个数组的交集 简单
 * @Date 2022/2/24
 */
//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 493 👎 0
public class Intersection {
    public int [] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i =0;i < nums1.length;i++){
            set1.add(nums1[i]);
        }
        for (int j = 0;j < nums2.length;j++){
            if (set1.contains(nums2[j])){
                set.add(nums2[j]);
            }
        }
        int [] ans = new int[set.size()];
        int index = 0;
        for (Integer num : set){
            ans[index++] = num;
        }
        return ans;
    }
}
