package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description 有效的字母异位词 简单
 * @Date 2022/2/24
 */
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//
//
// 示例 1:
//
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
//
//输入: s = "rat", t = "car"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= s.length, t.length <= 5 * 10⁴
// s 和 t 仅包含小写字母
//
//
//
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 哈希表 字符串 排序 👍 506 👎 0
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("anagram","nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i= 0;i <s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0;i < t.length();i++){
            if (!map.containsKey(t.charAt(i))){
                return false;
            }
            map.put(t.charAt(i),map.get(t.charAt(i)) -1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
