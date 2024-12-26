package company;

import java.util.HashSet;
import java.util.Set;

public class QskMpc202405 {
    public static void main(String[] args) {
        QskMpc202405 qskMpc202405 = new QskMpc202405();

    }
    public int maxDiffCnt(int[] ball1, int[] ball2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int n = ball1.length;
        for (int i = 0;i < n;i++){
            set1.add(ball1[i]);
            set2.add(ball2[i]);
        }
        if (set1.size() < n/2 && set2.size() < n/2){
            set1.addAll(set2);
            return set1.size();
        }
        Set<Integer> larger = set1.size() > set2.size() ? set1 : set2;
        Set<Integer> smaller = set2.size() < set1.size() ? set2 : set1;

        return 0;
    }
}
