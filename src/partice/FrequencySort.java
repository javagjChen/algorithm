package partice;

import java.util.*;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/29
 */
public class FrequencySort {

    public static void main(String[] args) {
        FrequencySort fs = new FrequencySort();
        int[] nums = new int[]{2,3,1,3,2};
        System.out.println(Arrays.toString(fs.frequencySort(nums)));
    }

    public int[] frequencySort(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0) +1);
        }
        TreeMap<Integer,List<Integer>> map2 = new TreeMap<>();
        int index = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            List<Integer> list2;
            int map2Key = entry.getValue();
            if (map2.containsKey(map2Key)){
                list2= map2.get(entry.getValue());
                for (int i =0;i < map2Key;i++){
                    list2.add(entry.getKey());
                }
            }else {
                list2 = new ArrayList<>();
                for (int i =0;i < map2Key;i++){
                    list2.add(entry.getKey());
                }
            }
            map2.put(entry.getValue(),list2);
        }
        for (Map.Entry<Integer,List<Integer>> entry : map2.entrySet()){
            List<Integer> value = entry.getValue();
            Collections.sort(value, (o1, o2) -> o2-o1);
            for (int i  =0;i < value.size();i++){
                nums[index++] = value.get(i);
            }
        }
        return nums;

    }
}
