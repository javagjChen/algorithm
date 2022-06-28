package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/25
 */
public class CountAsterisks {

    public static void main(String[] args) {
        CountAsterisks ca = new CountAsterisks();
        System.out.println(ca.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }
    public int countAsterisks(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int start = 0;
        int index = 0;
        int ans = 0;
        for (int end = 0;end < len;end++){
            if (chars[end] == '|' && index % 2 ==0){
                int count = getCount(chars,start,end);
                ans += count;
                index++;
            }else if (chars[end] == '|' && index % 2 ==1){
                start = end;
                index++;
            }
            if (end == len -1){
                int count = getCount(chars,start,end);
                ans += count;
            }
        }
        return ans;
    }

    private int getCount(char[] chars, int start, int end) {
        int count = 0;
        for (int i = start; i <= end;i++){
            if (chars[i] == '*'){
                count++;
            }
        }
        return count;
    }
}
