package stack;

import java.util.Stack;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/6
 */
public class Solution {
    public static void main(String[] args) {
        //System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String item : tokens){
            if (!item.equals("*") && !item.equals("+") && !item.equals("-") && !item.equals("/")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num2 - num1;
                }else if (item.equals("/")){
                    res = num2 / num1;
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }


}
