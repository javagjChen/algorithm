package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/21
 */
public class MinNumberOfHours {

    public static void main(String[] args) {
        MinNumberOfHours moh = new MinNumberOfHours();
        int initialEnergy =1;
        int initialExperience=1;
        int[] energy = new int[]{1,1,1,1};
        int[] experience = new int[]{1,1,1,50};
        System.out.println(moh.minNumberOfHours(initialEnergy,initialExperience,energy,experience));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 需要增加多少经验
        int init = initialExperience;
        int need = 0;
        for (int val : experience){
            if(val >= init){
                int t =  (val - init + 1);
                need += t;
                init += t;
            }
            init += val;
        }
        int total = 0;
        for (int val : energy){
            total += val;
        }
        int need2 = total - initialEnergy + 1;
        need2 = need2 <= 0 ? 0 :need2;
        return need +need2;
    }
}
