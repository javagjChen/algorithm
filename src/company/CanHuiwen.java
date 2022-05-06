package company;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chengj
 * @Description
 * @Date 2022/5/6
 */
public class CanHuiwen {

    public static void main(String[] args) {
        CanHuiwen canHuiwen = new CanHuiwen();
        System.out.println(canHuiwen.canHuiwen("abba"));
    }
    public boolean canHuiwen(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        List<Character> list = new LinkedList<>();
        for (Character character : chars){
            if (list.contains(character)){
                list.remove(character);
            }else {
                list.add(character);
            }
        }
        return list.size() <= 1;
    }
}
