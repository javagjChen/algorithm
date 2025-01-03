package string;

import java.util.Stack;

/**
 * @author chengj
 * @Description 394.字符串解码 中等
 * @Date 2022/8/10
 */
//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
// 示例 1：
//
//
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//
//
// 示例 2：
//
//
//输入：s = "3[a2[c]]"
//输出："accaccacc"
//
//
// 示例 3：
//
//
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//
//
// 示例 4：
//
//
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 30
// s 由小写英文字母、数字和方括号 '[]' 组成
// s 保证是一个 有效 的输入。
// s 中所有整数的取值范围为 [1, 300]
//
// Related Topics 栈 递归 字符串 👍 1257 👎 0
public class DecodeString {

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (Character character : s.toCharArray()){
            if(character == '['){
                stack.push(sb.toString());
                numStack.push(num);
                num = 0;
                sb = new StringBuilder();
            }else if(character - '0' >= 0 && character - '0' <= 9){
                num = num * 10 + character - '0';
            }else if (character == ']'){
                int size = numStack.pop();
                StringBuilder t = new StringBuilder();
                for (int i = 0;i < size; i++){
                    t.append(sb);
                }
                String last = stack.pop();
                sb = new StringBuilder(last + t);
            }else {
                sb.append(character);
            }
        }
        return sb.toString();
    }
}
