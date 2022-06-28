package company;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/24
 */
public class QskMpc202206 {
    public static void main(String[] args) {
        QskMpc202206 qskMpc202206 = new QskMpc202206();
        //System.out.println(qskMpc202206.getMaxScore(new int[]{7951,-1055,-2814,-6242,5971,-8123,2152,7286,-5950,9412,-1967,7719,9490,122,-200,6393,-61, -4824,759,-9929,872,4410,-9011,-6099,-2079,-6282,-5733,-5308,-6733,7624,3147,841,-5085, 3668,-6157,-4884,-8299,-308,5036,2191,-3,9809,-6944,-9345,8050,-9611,-1829,7839,8439,8834, 7257,1684,-1555,-3560,7318,7802,-283,-6310,898,-5647,-2543,1011,-5550,8066,-9124,-44,4998, 6182,-8771,4152,5801,5801,4621,9167,-7933,-7461,-4000,-1971,924,9996,-9725,5933,4174}));
        System.out.println(qskMpc202206.getMaxScore(new int[]{1,-2,-1,1}));
    }

    public int getMaxScore(int[] shangqiList){
        int len = shangqiList.length;
        int ans = 0;
        for (int index = 1;index <= len;index++){
            for (int i = 0;i < len - (index -1);i++){
                int sum = 0;
                int k = index;
                while (k >0){
                    sum += shangqiList[i + (k -1)];
                    k--;
                }
                sum = Math.abs(sum);
                ans = Math.max(ans,sum);
            }
        }
        return ans;

    }
}
