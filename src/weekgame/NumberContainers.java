package weekgame;

import java.util.*;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/23
 */
public class NumberContainers {

    public TreeMap<Integer,Integer> map;
    public NumberContainers() {
        map = new TreeMap<>();
    }

    public void change(int index, int number) {
        map.put(index,number);
    }

    public int find(int number) {
        if (!map.containsValue(number)){
            return -1;
        }
        //List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == number){
                return entry.getKey();
            }
        }
        //Collections.sort(list);
        return -1;
    }
}
