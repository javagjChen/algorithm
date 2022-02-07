package stringandarr;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description 有效括号
 * @Author chengj
 * @Date 2022/1/17
 */
public class IsValid {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (map.containsKey(c)){
                if (stack.isEmpty()){
                    return false;
                }
                if (!stack.peek().equals(map.get(c))){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
