package company;

/**
 * @author chengj
 * @Description 168.Excel表列名称 简单 01
 * @Date 2022/4/19
 */
//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//
// 例如：
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
//
// 示例 1：
//
//
//输入：columnNumber = 1
//输出："A"
//
//
// 示例 2：
//
//
//输入：columnNumber = 28
//输出："AB"
//
//
// 示例 3：
//
//
//输入：columnNumber = 701
//输出："ZY"
//
//
// 示例 4：
//
//
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
//
//
//
//
// 提示：
//
//
// 1 <= columnNumber <= 2³¹ - 1
//
// Related Topics 数学 字符串 👍 520 👎 0
public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            int t = (columnNumber)%26;
            ans.append((char)( t +'A'));
            columnNumber = columnNumber/26;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(28));
        int c = "A".charAt(0) -64;

        System.out.println();
    }

}
