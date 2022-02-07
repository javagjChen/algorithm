package stringandarr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 全排列
 * @Author chengj
 * @Date 2022/1/19
 */
public class Permute {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    /**
     * 利用回溯算法
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1){
            return result;
        }
        int len = nums.length;
        boolean [] used = new boolean[len];
        int deep = 0;
        List<Integer> subList = new ArrayList<>();
        dpf(nums,len,0,subList,used,result);
        return result;
    }

    public static void dpf(int[] nums, int len, int deep, List<Integer> subList,boolean [] used, List<List<Integer>> result) {
        if (deep == len){
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0;i < len;i++){
            if (!used[i]){
                subList.add(nums[i]);
                used[i] = true;
                dpf(nums,len,deep+1,subList,used,result);
                used[i] = false;
                subList.remove(deep);
            }

        }
    }
}
