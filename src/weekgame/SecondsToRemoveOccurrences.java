package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/20
 */
public class SecondsToRemoveOccurrences {

    public static void main(String[] args) {
        SecondsToRemoveOccurrences sro = new SecondsToRemoveOccurrences();
        System.out.println(sro.secondsToRemoveOccurrences("0110101"));
    }

    public int secondsToRemoveOccurrences(String s) {

        int ans = 0;
        while(s.contains("01")){
            s = s.replaceAll("01","10");
            ans++;
        }
        return ans;
    }
}
