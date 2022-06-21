package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/19
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        LongestSubsequence ls = new LongestSubsequence();
        System.out.println(ls.longestSubsequence("111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101",11713332));
    }
    public int longestSubsequence(String s, int k) {
        long target = k;
        long ans = 0;
        int len = s.length();
        long sum = 0;
        for (int i = len -1;i >= 0; i--){
            if (s.charAt(i) == '0'){
                ans++;
            }else {
                long t = getPreSum(ans);
                if (t + sum <= target){
                    sum += t;
                    ans++;
                }
            }
        }

        return (int)ans;
    }

    private long getPreSum(long len) {
        long ans = 1;
        while (len >0){
            len--;
            ans *= 2;
        }
        return ans;
    }
}
