package stringandarr;

/**
 * @Description 最长回文子串
 * @Author chengj
 * @Date 2022/1/12
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }

        boolean [] [] dp = new boolean[len][len];
        //初始化 长度为1的都是回文串
        for (int i = 0;i < len;i++){
            dp[i][i] = true;
        }
        char [] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 0;
        // L为子串的长度
        for ( int L = 2; L <= len;L++){
            // 从左边开始
            for (int i = 0;i < len;i++){
                // 右边结束为止 j - i + 1 = L
                int j = L + i -1;
                // 越界
                if (j >= len){
                    break;
                }
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && L >maxLen){
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
