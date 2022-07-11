package weekgame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/9
 */
public class LatestTimeCatchTheBus {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int n = buses.length;
        for (int i = n - 1;i >=0;i--){
            int begin = i > 0 ? buses[i -1] : 0;
            int end = buses[i];

            int count = 0;
            for (int j = passengers.length - 1; j >= 0;j--){
                if (passengers[j] > begin && passengers[j] <= end){
                    count++;
                }
                if (count >= capacity){

                }
            }
        }
        return 0;
    }
}
