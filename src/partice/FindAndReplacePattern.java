package partice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/20
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character,Character> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String word :words){
            map.clear();
            char[] chars = word.toCharArray();
            for (int i =0;i < chars.length;i++){
                if (map.containsKey(chars[i]) || map.containsValue(pattern.charAt(i))){
                    if(map.get(chars[i]) == null || map.get(chars[i]) != pattern.charAt(i)){
                        break;
                    }
                }else {
                    map.put(chars[i],pattern.charAt(i));
                }
            }
            ans.add(word);

        }
        return ans;
    }
}
