package weekgame;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description
 * @Date 2022/6/19
 */
public class GreatestLetter {

    public static void main(String[] args) {
        GreatestLetter gl = new GreatestLetter();
        System.out.println(gl.greatestLetter("arRAzFif"));
    }

    public String greatestLetter(String s) {
        Map<Character,String> map = new HashMap<>();
        initMap(map);
        String ans = "";
        String pre = "";
        for (char c :s.toCharArray()){
            if (map.containsKey(c)){
                if (s.contains(map.get(c))){
                    pre = map.get(c);
                    if ("".equals(ans)){
                        ans = pre;
                    }else {
                        if (ans.charAt(0) < pre.charAt(0)){
                            ans = pre;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private void initMap(Map<Character, String> map) {
        map.put('a',"A");
        map.put('b',"B");
        map.put('c',"C");
        map.put('d',"D");
        map.put('e',"E");
        map.put('f',"F");
        map.put('g',"G");
        map.put('h',"H");
        map.put('i',"I");
        map.put('j',"J");
        map.put('k',"K");
        map.put('l',"L");
        map.put('n',"N");
        map.put('m',"M");
        map.put('o',"O");
        map.put('p',"P");
        map.put('q',"Q");
        map.put('r',"R");
        map.put('s',"S");
        map.put('t',"T");
        map.put('u',"U");
        map.put('v',"V");
        map.put('w',"W");
        map.put('x',"X");
        map.put('y',"Y");
        map.put('z',"Z");
    }
}
