package weekgame;

import java.util.*;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/6
 */
public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] item : items1){
            treeMap.put(item[0],item[1]);
        }
        for (int[] item : items2){
            treeMap.put(item[0],treeMap.getOrDefault(item[0],0) + item[1]);
        }
        for (Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            ans.add(list);
        }
        return ans;
    }
}
