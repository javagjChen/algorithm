package weekgame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/23
 */
public class BestHand {

    public String bestHand(int[] ranks, char[] suits) {

        char c = suits[0];
        int sCount = 1;
        for (int i = 1;i< suits.length;i++){
            if (c == suits[i]){
                sCount++;
            }
        }
        if (sCount == 5){
            return "Flush";
        }
        Arrays.sort(ranks);
        int ans = 0;
        int max = 1;
        int t = ranks[0];
        for (int i =1; i < ranks.length;i++ ){
            if (ranks[i] == t){
                max++;
            }else {
                t = ranks[i];
                max = 1;
            }
            ans = Math.max(ans,max);

        }
        if (ans >=3){
            return "Three of a Kind";
        }else if (ans == 2){
            return "Pair";
        }else {
            return "High Card";
        }
    }
}
