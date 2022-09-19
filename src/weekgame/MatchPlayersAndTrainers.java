package weekgame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/17
 */
public class MatchPlayersAndTrainers {

    public static void main(String[] args) {
        MatchPlayersAndTrainers mpat = new MatchPlayersAndTrainers();
        int[] player = new int[]{4,7,9};
        int[] trainers = new int[]{8,2,5,8};
        System.out.println(mpat.matchPlayersAndTrainers(player,trainers));
        System.out.println(7 %7);
    }
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int end = players.length - 1;
        int ans = 0;
        for (int i = trainers.length -1;i >= 0;i--){
            for (int j = end; j >= 0;j--){
                if(trainers[i] >= players[j]){
                    ans++;
                    end = j - 1;
                    break;
                }
            }
        }
        return ans;


    }

}
