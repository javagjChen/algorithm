package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chengj
 * @Description 赎金信 简单
 * @Date 2022/2/25
 */
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= ransomNote.length, magazine.length <= 10⁵
// ransomNote 和 magazine 由小写英文字母组成
//
// Related Topics 哈希表 字符串 计数 👍 278 👎 0
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        int[] arr = new int[26];
        int tmp;
        for (Character character : magazine.toCharArray()){
            tmp = character - 'a';
            arr[tmp]++;
        }
        for (Character character : ransomNote.toCharArray()){
            tmp = arr[character - 'a'];
            if (tmp > 0){
                arr[character - 'a']--;
            }else {
                return false;
            }

        }
        return true;
    }
}
