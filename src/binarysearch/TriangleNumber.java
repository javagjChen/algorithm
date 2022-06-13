package binarysearch;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 611.有效三角形的个数 中等
 * @Date 2022/6/13
 */
//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,2,3,4]
//输出: 3
//解释:有效的组合是:
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
//
//
// 示例 2:
//
//
//输入: nums = [4,2,3,4]
//输出: 4
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 1000
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 400 👎 0
public class TriangleNumber {

    public static void main(String[] args) {
        TriangleNumber tn = new TriangleNumber();
        int [] nums = new int[]{4,2,3,4};
        System.out.println(tn.triangleNumber(nums));
    }

    public int triangleNumber(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len;i++){
            for (int j = i + 1; j < len;j++){
                int a = nums[i];
                int b = nums[j];
                int l = j;
                int r = len;
                while (l + 1 != r){
                    int mid = l + (r - l)/2;
                    if (nums[mid] < a + b){
                        l = mid;
                    }else {
                        r = mid;
                    }
                }
                if (l != j ){
                    ans += (l - j);
                }
            }
        }
        return ans;
    }
}
