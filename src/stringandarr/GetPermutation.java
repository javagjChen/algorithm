package stringandarr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 排序序列
 * @Author chengj
 * @Date 2022/1/26
 */
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
//
// 给定 n 和 k，返回第 k 个排列。
//
//
//
// 示例 1：
//
//
//输入：n = 3, k = 3
//输出："213"
//
//
// 示例 2：
//
//
//输入：n = 4, k = 9
//输出："2314"
//
//
// 示例 3：
//
//
//输入：n = 3, k = 1
//输出："123"
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
// 1 <= k <= n!
//
// Related Topics 递归 数学 👍 619 👎 0
public class GetPermutation {

    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }

    public static String getPermutation(int n, int k) {
        int [] nums = new int[n];
        // 初始化
        for (int i = 1;i<=n;i++){
            nums[i -1] = i;
        }
        List<List<Integer>> permuteList = permute(nums,k);
        List<Integer> list = permuteList.get(k - 1);
        StringBuffer result = new StringBuffer();
        for (Integer integer : list){
            result.append(integer);
        }
        return result.toString();
    }

    public static List<List<Integer>> permute(int [] nums,int k){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        boolean [] used = new boolean[len];
        List<Integer> tmp = new ArrayList<>();
        dfp(nums,len,0,used,tmp,result,k);
        return result;
    }

    private static void dfp(int[] nums, int len, int depth, boolean[] used, List<Integer> tmp, List<List<Integer>> result,int k) {
        if (depth ==len){
            List<Integer> list = new ArrayList<>(tmp);
            result.add(list);
            return;
        }

        for (int i =0 ;i < len;i++){
            if (used[i]){
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            dfp(nums,len,depth + 1,used,tmp,result,k);
            used[i] = false;
            tmp.remove(depth);
            if (result.size() == k){
                return;
            }
        }
    }
}
