package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/18
 */
public class LongestContinuousSubstring {

    public static void main(String[] args) {
        LongestContinuousSubstring lcs = new LongestContinuousSubstring();
        System.out.println(lcs.longestContinuousSubstring("abef"));
    }

    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int maxLen = 1;
        int left = 0;
        int pre = s.charAt(0) - 'a';
        for (int i = 1;i < n;i++){
            int charAt = s.charAt(i) - 'a';
            if (charAt - pre == 1){
                maxLen = Math.max(maxLen,i - left + 1);

            }else {
                left = i;
            }
            pre = charAt;


        }
        return maxLen;
    }
}
