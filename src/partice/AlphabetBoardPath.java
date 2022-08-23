package partice;

/**
 * @author chengj
 * @Description 1138.字母板上的路径 中等
 * @Date 2022/8/19
 */
//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
//
//
//
// 我们可以按下面的指令规则行动：
//
//
// 如果方格存在，'U' 意味着将我们的位置上移一行；
// 如果方格存在，'D' 意味着将我们的位置下移一行；
// 如果方格存在，'L' 意味着将我们的位置左移一列；
// 如果方格存在，'R' 意味着将我们的位置右移一列；
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
//
//
// （注意，字母板上只存在有字母的位置。）
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
//
//
//
// 示例 1：
//
//
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
//
//
// 示例 2：
//
//
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
//
//
//
//
// 提示：
//
//
// 1 <= target.length <= 100
// target 仅含有小写英文字母。
//
// Related Topics 哈希表 字符串 👍 44 👎 0
public class AlphabetBoardPath {
    public static void main(String[] args) {
        AlphabetBoardPath abp  = new AlphabetBoardPath();
        System.out.println(abp.alphabetBoardPath("zb"));
    }

    /**
     * 关键点：对z的处理，2 difCol 和 difRow怎么得来
     * @param target
     * @return
     */
    public String alphabetBoardPath(String target) {

        StringBuilder ans = new StringBuilder();
        int pre = 0;
        for (int i = 0;i < target.length();i++){
            int tar = target.charAt(i) - 'a';
            // 对z的特殊处理
            if (pre == 25 && tar != 25){
                ans.append('U');
                pre = 'u' - 'a';
            }
            int difCol = (tar%5) - (pre%5);
            char dir = 'R';
            if (difCol < 0){
                difCol = - difCol;
                dir = 'L';
            }
            for (int j = 0; j < difCol;j++){
                ans.append(dir);
            }
            int difRow = (tar/5) - (pre/5);
            dir = 'D';
            if (difRow < 0){
                difRow = -difRow;
                dir = 'U';
            }
            for (int j =0 ;j< difRow;j++){
                ans.append(dir);
            }
            ans.append('!');
            pre = tar;
        }
        return ans.toString();

    }



}
