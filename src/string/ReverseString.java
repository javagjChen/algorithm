package string;

/**
 * @author chengj
 * @Description 反转字符串 简单
 * @Date 2022/2/25
 */
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//
//
// 示例 1：
//
//
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//
//
// 示例 2：
//
//
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s[i] 都是 ASCII 码表中的可打印字符
//
// Related Topics 递归 双指针 字符串 👍 531 👎 0
public class ReverseString {

    public void reverseString(char[] s) {

        int len = s.length;
        for (int i = 0; i < len /2;i++){
            s[i] = (char) (s[i] ^ s[len - i - 1]);
            s[len - i - 1] = (char) (s[i] ^ s[len - i - 1]);
            s[i] = (char) (s[i] ^ s[len - i - 1]);
        }
    }
}
