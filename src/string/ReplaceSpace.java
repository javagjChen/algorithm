package string;

/**
 * @author chengj
 * @Description 替换空格 简单
 * @Date 2022/2/28
 */
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// Related Topics 字符串 👍 219 👎 0
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("We are happy."));
        String a = "We are happy.";
        char [] chars = a.toCharArray();
        char[] test = new char[chars.length *3];
        for (int i =0,j =0; i < a.toCharArray().length;i++){
            Character c = a.charAt(i);
            if (c == ' '){
                test[j] = '%';
                test[j+1] = '2';
                test[j+2] = '0';
                j += 3;
            }else {
                test[j] = c;
                j++;
            }
        }
        System.out.println(new String(test).trim());
    }
    public String replaceSpace(String s) {
        //return s.replaceAll(" ","%20");
        char [] chars = s.toCharArray();
        char[] test = new char[chars.length *3];
        int j =0;
        for (int i =0; i < chars.length;i++){
            Character c = s.charAt(i);
            if (c == ' '){
                test[j] = '%';
                test[j+1] = '2';
                test[j+2] = '0';
                j += 3;
            }else {
                test[j] = c;
                j++;
            }
        }
        return new String(test,0,j);
    }
}
