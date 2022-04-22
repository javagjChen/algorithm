package string;

/**
 * @author chengj
 * @Description 14.最长公共前缀 简单
 * @Date 2022/4/22
 */
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串 👍 2199 👎 0
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = new String[]{"dog","dracecar","dar"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        while (index <= strs[0].length()){
            String tmp = strs[0].substring(0,index);
            boolean flag = false;
            for (int i = 1; i < strs.length;i++){
                if (strs[i].length() == 0){
                    return "";
                }
                if (index <= strs[i].length()){
                    if (!tmp.equals(strs[i].substring(0,index))){
                        flag = true;
                        break;
                    }
                }else {
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
            index++;
        }
        return strs[0].substring(0,index-1);
    }
}
