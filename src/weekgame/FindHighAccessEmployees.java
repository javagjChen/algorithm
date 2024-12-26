package weekgame;

import java.util.*;

public class FindHighAccessEmployees {
    public static void main(String[] args) {
        FindHighAccessEmployees f = new FindHighAccessEmployees();
        List<List<String>> access_times = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("0549");
        access_times.add(list);
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("0532");
        access_times.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("0621");
        access_times.add(list3);
        f.findHighAccessEmployees(access_times);

    }
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<String>> map = new HashMap<>();
        for (List<String> access : access_times){
            List<String> list = map.getOrDefault(access.get(0), new ArrayList<>());
            list.add(access.get(1));
            map.put(access.get(0),list);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry : map.entrySet()){
            List<String> value = entry.getValue();
            if (value.size() >= 3){
                Collections.sort(value);
                int n = value.size();
                for (int i = 0;i <= n - 3;i++){
                    int e = Integer.parseInt(value.get(i + 2));
                    int s = Integer.parseInt(value.get(i));
                    int minE = e%100;
                    int minS = s%100;
                    int hourE = e/100;
                    int hourS = s/100;
                    if (hourS == hourE && minE >= minS){
                        ans.add(entry.getKey());
                        break;
                    }else if(hourE == hourS + 1 && (minE + 60 - minS) < 60) {
                        ans.add(entry.getKey());
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
