package weekgame;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/3
 */
public class DecodeMessage {

    public static void main(String[] args) {

        DecodeMessage dm = new DecodeMessage();
        System.out.println(dm.decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv"));


    }

    public String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        int len = key.length();
        int index = 0;
        for (int i = 0;i < len; i++){
            char c = key.charAt(i);
            if (c != ' '){

                if (map.containsKey(c)){
                    continue;
                }
                map.put(c,(char)((char)index + 97));
                index++;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < message.length();i++){
            char c = message.charAt(i);
            if (c == ' '){
                sb.append(c);
            }else {
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }
}
