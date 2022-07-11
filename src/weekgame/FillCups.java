package weekgame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/10
 */
public class FillCups {

    public static void main(String[] args) {
        int[] amount = new int[]{5,4,4};
        FillCups fc = new FillCups();
        System.out.println(fc.fillCups(amount));
    }
    public int fillCups(int[] amount) {
        int ans = 0;

        Arrays.sort(amount);
        int max = amount[2];
        int mid = amount[1];
        int min = amount[0];
        while (max > 0 || mid > 0 || mid >0){
            if (max > 0 && mid >0) {
                ans++;
                max--;
                mid--;
            }else if (max> 0 && mid ==0){
                max--;
                ans++;

            }else if (mid > 0 && max ==0){
                mid--;
                ans++;
            }

            int t = max;
            if (mid > max){
                max = mid;
                mid = t;
            }
            int t2 = min;
            if (min > mid){
                min = mid;
                mid = t2;
            }

        }
        return ans;
    }
}
