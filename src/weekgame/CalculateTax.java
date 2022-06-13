package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/12
 */
public class CalculateTax {

    public static void main(String[] args) {
        CalculateTax ct = new CalculateTax();
        int[][] brackets = new int[][]{{2,7},{3,17},{4,37},{7,6},{9,83},{16,67},{19,29}};
        int income = 18;
        System.out.println(ct.calculateTax(brackets,income));
    }
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0.0;
        int a = income;
        for (int i = 0; i < brackets.length;i++){
            int[] tmp = brackets[i];
            int b = 0;
            if (i != 0){
                b = brackets[i-1][0];
            }
            if (income >= tmp[0]){
                ans = ans + ( ((double)tmp[0] - b) * ((double)tmp[1] * 0.01));
                //income -= (tmp[0] - b);
            }else {
                ans = ans + ((double) (a - b) * ((double)tmp[1] * 0.01));
                break;
            }
        }
        return ans;
    }

}
