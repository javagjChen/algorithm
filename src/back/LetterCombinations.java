package back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengj
 * @Description 17.电话号码的字母组合 中等
 * @Date 2022/3/16
 */
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 哈希表 字符串 回溯 👍 1775 👎 0
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("2"));
    }
    public Map<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        init();
        List<String> ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        doCombinations(ans,stringBuilder,0,digits.length(),digits);
        return ans;
    }

    private void init() {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    private void doCombinations(List<String> ans, StringBuilder stringBuilder,
                                int index, int len,String digits) {
        if (index == len){
            ans.add(new String(stringBuilder));
            return;
        }
        Character character = digits.charAt(index);
        String tmp = map.get(character);
        for (int i = 0;i < tmp.length();i++){
            stringBuilder.append(tmp.charAt(i));
            doCombinations(ans,stringBuilder,index +1,len,digits);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

}
