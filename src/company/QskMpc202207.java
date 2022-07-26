package company;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/22
 */
public class QskMpc202207 {

    public static void main(String[] args) {
        QskMpc202207 qskMpc202207 = new QskMpc202207();
        int[] vegetables = new int[]{1,2,3};
        int[] effective = new int[]{2,2,5};
        System.out.println(qskMpc202207.maxVegetableDays(vegetables,effective));
    }

    public int maxVegetableDays(int[] vegetables, int[] effective) {
        int n = vegetables.length;
        int max = 0;
        int ans = 0;
        for (int i = 0;i < n; i++){
            max = Math.max(max -1,Math.min(vegetables[i],effective[i]));
            if (max != 0 && i != n -1){
                ans++;
            }
            if(i == n -1 && max > 0){
                max--;
                ans++;
            }
        }
        return max + ans;
    }
}
