package partice;

import java.util.Stack;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/25
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == 'a'){
                stack.push(c);
            }else if (c == 'b'){
                if (stack.isEmpty()){
                    return false;
                }
                stack.push(c);
            }else {
                if (stack.size() != 2){
                    return false;
                }
                char b = stack.pop();
                char a = stack.pop();
                if (a != 'a' || b != 'b'){
                    return false;
                }
            }
        }
        return stack.isEmpty();


    }
}
