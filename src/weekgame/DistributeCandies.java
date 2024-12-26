package weekgame;

import java.util.ArrayList;
import java.util.List;

public class DistributeCandies {

    public static void main(String[] args) {
        DistributeCandies candies = new DistributeCandies();
        System.out.println(candies.distributeCandies(5,2));
    }
    public int distributeCandies(int n, int limit) {
        int[][] dp = new int[3][n+1];
        for(int i = 0;i < 3;i++){
            dp[i][1] = 1;
        }
        for(int i = 0;i < 3;i++){
            for (int j = 1;j <= n;j++){
                if( j < (i + 1) * limit){

                }
            }
        }
        return dp[2][n];
    }


}
