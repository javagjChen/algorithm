package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/20
 */
public class ShiftingLetters {

    public static void main(String[] args) {
        ShiftingLetters sl = new ShiftingLetters();
        int[][] shifts = new int[][]{{0,0,0},{1,1,1}};
        System.out.println(sl.shiftingLetters("dztz",shifts));
        char x = 'x';
        System.out.println('z' - x);
        x = 'a';
        System.out.println((char)( x - (96) + 'a'));
    }
    // 思路不对，这种思路会超时
    public  int[] help;
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        char[] ans = s.toCharArray();
        help = new int[n];

        for (int[] arr : shifts){
            for (int i = arr[0];i <= arr[1];i++){
                if (arr[2] == 0){
                    help[i]++;
                }else {
                    help[i]--;
                }
            }
        }
        for (int i = 0;i < n;i++){
            if (help[i] > 0){
                help[i] %= 26;
                while (help[i] != 0){
                    if (ans[i] == 'a'){
                        ans[i] = 'z';
                    }else {
                        ans[i] = (char) (ans[i] - 98 + 'a');
                    }
                    help[i]--;
                }

            }else {
                while (help[i] != 0){
                    if(ans[i] == 'z'){
                        ans[i] = 'a';
                    }else {
                        ans[i] = (char) (ans[i] - 96 + 'a');
                    }

                    help[i]++;
                }

            }
        }
        return new String(ans);
    }

    /**
     * 初始化一个差分数组（把每一次操作的结果都记录下来），此后的区间修改操作将在这个数组上进行
     * 将 [i, j] 区间的值加上或减去 某个值，只需要在差分数组中i和j的位置 分别加上 这个值 即可
     * 差分数组反推出原数组（通过前缀和推出）
     *
     * @param s
     * @param shifts
     * @return
     */
    public String shiftingLetters2(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] cs = new int[chars.length];
        // 原始字符串的每个字符的ascii码
        for (int i = 0; i < chars.length; i++) {
            cs[i] = chars[i] - 'a';
        }

        // 建立差分数组
        long[] difference = new long[cs.length];
        difference[0] = cs[0];
        for (int i = 1; i < cs.length; i++) {
            difference[i] = cs[i] - cs[i - 1];
        }

        // 差分数组上区间操作
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1];
            int direction = shift[2];
            direction = (direction == 1) ? 1 : -1;
            difference[start] += direction;
            if (end + 1 < difference.length) {
                difference[end + 1] -= direction;
            }
        }

        // 差分数组反推出原数组
        long[] result = new long[cs.length];
        result[0] = (difference[0]) % 26;
        for (int i = 1; i < difference.length; i++) {
            result[i] = (result[i - 1] + difference[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for (long j : result) {
            // 有可能是负数(范围在[-25,0] )，所以要加上26
            if (j < 0) j = 26 + j;
            j = j % 26;
            sb.append((char) (j + 'a'));
        }
        return sb.toString();
    }

}
