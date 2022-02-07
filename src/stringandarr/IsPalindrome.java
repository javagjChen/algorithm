package stringandarr;

/**
 * @Description
 * @Author chengj
 * @Date 2022/1/12
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        if (x <=9){
            return true;
        }
        String s = String.valueOf(x);
        for (int i = 0;i <= s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
