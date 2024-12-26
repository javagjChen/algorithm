package company;

import java.util.Arrays;

public class QskMpc202407 {
    public static void main(String[] args) {
        QskMpc202407 qskMpc202407 = new QskMpc202407();
        int[] power = new int[]{3,2,1};
        System.out.println(qskMpc202407.finishAll(power,5));
    }
    public long finishAll(int[] power, int m) {
        int n = power.length;
        Arrays.sort(power);
        int[] last = new int[n];
        long lastVal = power[0];
        int base = 1;
        long ans = lastVal;
        m -= 1;
        while (m > 0){
            long future = (long) (Math.pow(base + 1,2) * power[0]);
            for (int i = 1;i < n;i++){
                long t = (long) (Math.pow(last[i] + 1,2) * power[i]);
                if(t > future){
                    ans += future;
                    ans -= lastVal;
                    lastVal = future;
                    base++;
                    m--;
                    break;
                }else {
                    ans += t;
                    ans -= (long) (Math.pow(last[i],2) * power[i]);
                    last[i]++;
                    m--;
                }
                if (m ==0){
                    return ans;
                }
            }
        }
        return ans;

    }

}
