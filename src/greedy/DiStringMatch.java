package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/6
 */
public class DiStringMatch {

    public static void main(String[] args) {
        DiStringMatch dm = new DiStringMatch();
        System.out.println(Arrays.toString(dm.diStringMatch("IDID")));
    }

    public int[] diStringMatch(String s) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.add(index);
        index++;
        List<Integer> list = new ArrayList<>();
        for(Character c : s.toCharArray()){
            if(c == 'D'){
                list.add(index);
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
            }else{
                stack.add(index);
            }
            index++;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        int [] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
