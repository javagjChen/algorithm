package weekgame;

import java.util.*;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/12
 */
public class DistributeCookies {

    public static void main(String[] args) {
        DistributeCookies dc = new DistributeCookies();
        int[] cookies = new int[]{8,15,10,20,8};
        int k = 2;
        System.out.println(dc.distributeCookies(cookies,k));
    }
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        LinkedList<Integer> linkedList = new LinkedList();
        for (int val: cookies){
            linkedList.add(val);
        }
        boolean flag = false;
        Map<Integer,List<Integer>> map = new HashMap<>();
        while (!linkedList.isEmpty()){
            if (flag){
                for (int i = 0; i < k;i++){
                    List<Integer> list1 = map.get(i);
                    if (list1 == null){
                        list1 = new ArrayList<>();
                    }
                    list1.add(linkedList.pollFirst());
                    map.put(i,list1);
                }
            }else{
                for (int i = 0; i < k;i++){
                    List<Integer> list1 = map.get(i);
                    if (list1 == null){
                        list1 = new ArrayList<>();
                    }
                    list1.add(linkedList.pollLast());
                    map.put(i,list1);
                }

            }
            flag = !flag;
        }
        int ans = 0;
        for (Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
            List<Integer> list1 = entry.getValue();
            int sum =0;
            if (list1.size() >= 1){
                for (int val: list1){
                    sum += val;
                }
            }

            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
