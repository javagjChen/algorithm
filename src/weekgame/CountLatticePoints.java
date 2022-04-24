package weekgame;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chengj
 * @Description
 * @Date 2022/4/24
 */
public class CountLatticePoints {
    public static void main(String[] args) {
        CountLatticePoints countLatticePoints = new CountLatticePoints();
        int[][] circles = new  int[][]{{2,2,2},{3,4,1}};
        System.out.println(countLatticePoints.countLatticePoints(circles));
    }
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        for (int i = 0;i < circles.length;i++){
            int h = circles[i][0];
            int r = circles[i][2];
            int s = circles[i][1];
            for (int j = h - r; j <= h + r;j++){
                for(int k = s - r; k <= s + r; k++){
                    int x = Math.abs(j-h),y = Math.abs(k-s);
                    if (x*x + y*y <= r*r){
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(j + "," + k);
                        set.add(stringBuilder.toString());
                    }
                }
            }
        }

        return set.size();
    }
}
