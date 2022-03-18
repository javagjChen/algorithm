package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 131.分割回文串 中等
 * @Date 2022/3/16
 */
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
// Related Topics 字符串 动态规划 回溯 👍 1035 👎 0
public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        doPartition(ans,list,s,0);
        return ans;
    }


    private void doPartition(List<List<String>> ans,List<String> list,String s,int index){
        if (index >= s.length()) {
            List<String> tmp = new ArrayList<>(list);
            ans.add(tmp);
            return;
        }
        for (int i = index;i<s.length();i++){
            String t = s.substring(index,i + 1);
            if (isBack(t)){
                list.add(t);
            }else {
                continue;
            }
            doPartition(ans,list,s,i+1);
            list.remove(list.size() -1);
        }
    }

    private boolean isBack(String str){
        if (str.length() == 0){
            return false;
        }
        if (str.length() == 1){
            return true;
        }
        int len = str.length();
        for (int i = 0; i<len/2;i++){
            if (str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("aab").toString());
    }
}
