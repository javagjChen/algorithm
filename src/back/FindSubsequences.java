package back;

import java.util.*;

public class FindSubsequences {
    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        System.out.println(findSubsequences.findSubsequences(new int[]{4,6,7,7}).toString());
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        doFindSubsequences(ans,list,nums,0);
        return ans;
    }

    private void doFindSubsequences(List<List<Integer>> ans, Deque<Integer> list, int[] nums, int index) {
        if (list.size() > 1){
            ans.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index;i<nums.length;i++){
            if ((!list.isEmpty()&& nums[i] < list.peekLast())|| set.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);
            doFindSubsequences(ans,list,nums,i +1);
            list.removeLast();
        }
    }
}
