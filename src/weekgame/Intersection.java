package weekgame;

import java.util.*;

/**
 * @author chengj
 * @Description
 * @Date 2022/4/24
 */
public class Intersection {

    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            for (int j =0; j < nums[i].length;j++){
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0) + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == nums.length){
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
