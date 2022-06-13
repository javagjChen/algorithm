package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/11
 */
public class StrongPasswordCheckerII {


    public static void main(String[] args) {
        StrongPasswordCheckerII spc = new StrongPasswordCheckerII();
        System.out.println(spc.strongPasswordCheckerII("Me+You--IsMyDream"));
    }
    public String little = "abcdefghijklmnopqrstuvwxyz";
    public String digital = "1234567890";
    public String larger = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String special = "!@#$%^&*()-+";
    public boolean strongPasswordCheckerII(String password) {

        int len = password.length();
        if (len < 8){
            return false;
        }

        boolean ans = false;
        for (char c : password.toCharArray()){
            String str = String.valueOf(c);
            if (little.contains(str)){
                ans = true;
                break;
            }

        }
        if (!ans){
            return false;
        }
        ans = false;
        for (char c : password.toCharArray()){
            String str = String.valueOf(c);
            if (digital.contains(str)){
                ans = true;
                break;
            }

        }
        if (!ans){
            return false;
        }
        ans = false;
        for (char c : password.toCharArray()){
            String str = String.valueOf(c);
            if (larger.contains(str)){
                ans = true;
                break;
            }

        }
        if (!ans){
            return false;
        }
        ans = false;
        for (char c : password.toCharArray()){
            String str = String.valueOf(c);
            if (special.contains(str)){
                ans = true;
                break;
            }

        }
        if (!ans){
            return false;
        }
        for (int i = 0;i< len;i++){
            String str = String.valueOf(password.charAt(i));
            if (i > 0 && str.equals(String.valueOf(password.charAt(i - 1)))){
                return false;
            }
        }
        return true;

    }
}
