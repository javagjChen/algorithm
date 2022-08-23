package weekgame;

import java.util.*;

/**
 * @author chengj
 * @Description 6166. 最大回文数字
 * @Date 2022/8/21
 */
//给你一个仅由数字（0 - 9）组成的字符串 num 。
//
// 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
//
// 注意：
//
//
// 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
// 数字可以重新排序。
//
//
//
//
// 示例 1：
//
//
//输入：num = "444947137"
//输出："7449447"
//解释：
//从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
//可以证明 "7449447" 是能够形成的最大回文整数。
//
//
// 示例 2：
//
//
//输入：num = "00009"
//输出："9"
//解释：
//可以证明 "9" 能够形成的最大回文整数。
//注意返回的整数不应含前导零。
//
//
//
//
// 提示：
//
//
// 1 <= num.length <= 10⁵
// num 由数字（0 - 9）组成
//
// 👍 6 👎 0
public class LargestPalindromic {

    public static void main(String[] args) {
        LargestPalindromic lp = new LargestPalindromic();
        System.out.println(lp.largestPalindromic2("00000000000000000000000000000000000000000000000000000000"));
    }

    /**
     * 没有在规定时间内做出来，问题出在对前置0的处理
     * @param num
     * @return
     */
    public String largestPalindromic(String num) {
        TreeMap<Integer,Integer> map = new TreeMap<>((o1, o2) -> o2-o1);

        for (int i = 0;i < num.length();i++){
            char charAt = num.charAt(i);
            int t = charAt - 48;

            map.put( t,map.getOrDefault(t,0) +1 );
        }
        int max = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue()%2==1 && entry.getKey() >= max){
                max = entry.getKey();
            }
        }


        StringBuilder sb = new StringBuilder();
        String tmp = "";
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue()%2 == 0){
                for (int i = 0;i < entry.getValue()/2;i++){
                    sb.append(entry.getKey());
                }
            }else {
                if (entry.getKey() == max){
                    tmp = max + "";
                }
                if (entry.getValue() > 1){
                    for (int i = 0;i < entry.getValue()/2;i++){
                        sb.append(entry.getKey());
                    }
                }
            }
        }

        while (sb.toString().startsWith("0")){
            sb = new StringBuilder(sb.toString().replaceFirst("0",""));
        }
        String ans = sb.toString();

        sb.reverse();
        if ("".equals(tmp) && !"".equals(ans)){
            return ans + sb;
        }else if( "".equals(ans)) {
            return "".equals(tmp)  ? "0" : tmp;
        }else{
            return ans + tmp + sb;
        }
    }

    /**
     *
     * @param num
     * @return
     */
    public String largestPalindromic2(String num) {
        int[] cnt = new int[10];
        for (int i = 0;i <num.length();i++) { /* 统计每个数字出现的次数 */
            cnt[num.charAt(i) - '0']++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && ans.length() == 0) { /* 0之前没有更大数据, 不放前导0 */
                break;
            }
            int len = cnt[i] / 2;
            for (int j = 0; j < len; j++) { /* 拆成偶数, 防止在字符串前后 */
                ans.append(i);
            }
            cnt[i] %= 2;
        }

        StringBuilder res = new StringBuilder(ans); /* 镜像字符串 */
        res.reverse();
        for (int i = 9; i >= 0; i--) { /* 中间再防止一个数字 */
            if (cnt[i] > 0) {
                ans.append(i);
                break;
            }
        }
        return ans.append(res).toString();

    }
}
