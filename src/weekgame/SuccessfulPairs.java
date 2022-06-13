package weekgame;

import java.util.Arrays;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/11
 */
public class SuccessfulPairs {

    public static void main(String[] args) {
        SuccessfulPairs sp = new SuccessfulPairs();
        int[] spells = new int[]{5,1,3};
        int[] potions = new int[]{1,2,3,4,5};
        long success = 7;
        System.out.println(Arrays.toString(sp.successfulPairs(spells,potions,success)));
        int a = 100000;
        int b = 100000;
        long c =(long) a*b;
        System.out.println(c);
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        for (int i = 0;i < n;i++){
            int l = -1;
            int r = m;
            while (l + 1 != r){
                int mid = l + (r - l)/2;
                long t = (long)potions[mid] * spells[i];
                if (t < success){
                    l = mid;
                }else {
                    r = mid;
                }
            }

            ans[i] = (m - r);

        }
        return ans;
    }
}
