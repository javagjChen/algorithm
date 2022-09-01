package partice;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/31
 */
public class AverageWaitingTime {

    public static void main(String[] args) {
        AverageWaitingTime awt = new AverageWaitingTime();
        int[][] customers  =  new int[][]{{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}};
    }

    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double sum = 0;
        double pre = 0;
        for(int i = 0;i <n;i++){
            if(i == 0){
                pre = customers[i][0] + customers[i][1];
            }else{
                if(customers[i][0] < pre){
                    sum += (pre - customers[i][0]);
                }
                pre = Math.max(pre,customers[i][0]) + customers[i][1];
            }
            sum += customers[i][1];
        }

        return sum/n;

    }
}
