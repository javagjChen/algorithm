package partice;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/25
 */
public class MaxDiff {

    public static void main(String[] args) {
        MaxDiff md = new MaxDiff();
        System.out.println(md.maxDiff(1101057));
    }
    public int maxDiff(int num) {
        String aStr = String.valueOf(num);
        char[] chars = aStr.toCharArray();
        char old = '0';
        for (int i = 0;i < aStr.length();i++){
            if(chars[i] != '9'){
                old = chars[i];
                break;
            }
        }
        int a = Integer.parseInt(new String(chars).replace(old,'9'));
        int b = 0;

        for (int i = 0;i < aStr.length();i++){
            if(i == 0) {
                if (chars[i] != '1'){
                    b = Integer.parseInt(new String(chars).replace(chars[i],'1'));
                    break;
                }
            }else {
                if (chars[i] != '0' && chars[i] != '1'){
                    b = Integer.parseInt(new String(chars).replace(chars[i],'0'));
                    break;
                }
            }
        }
        if(b == 0){
            b = Integer.parseInt(new String(chars));
        }

        return a - b;
    }
}
