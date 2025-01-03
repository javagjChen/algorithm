package partice;

/**
 * @author chengj
 * @Description 1375.二进制字符串前缀一致的次数 中等
 * @Date 2022/9/1
 */
//给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
//
// 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
//
// 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间 [1, i] 内的所有位都是 1 ，而其他位都是 0 。
//
// 返回二进制字符串在翻转过程中 前缀一致 的次数。
//
//
//
// 示例 1：
//
//
//输入：flips = [3,2,4,1,5]
//输出：2
//解释：二进制字符串最开始是 "00000" 。
//执行第 1 步：字符串变为 "00100" ，不属于前缀一致的情况。
//执行第 2 步：字符串变为 "01100" ，不属于前缀一致的情况。
//执行第 3 步：字符串变为 "01110" ，不属于前缀一致的情况。
//执行第 4 步：字符串变为 "11110" ，属于前缀一致的情况。
//执行第 5 步：字符串变为 "11111" ，属于前缀一致的情况。
//在翻转过程中，前缀一致的次数为 2 ，所以返回 2 。
//
//
// 示例 2：
//
//
//输入：flips = [4,1,2,3]
//输出：1
//解释：二进制字符串最开始是 "0000" 。
//执行第 1 步：字符串变为 "0001" ，不属于前缀一致的情况。
//执行第 2 步：字符串变为 "1001" ，不属于前缀一致的情况。
//执行第 3 步：字符串变为 "1101" ，不属于前缀一致的情况。
//执行第 4 步：字符串变为 "1111" ，属于前缀一致的情况。
//在翻转过程中，前缀一致的次数为 1 ，所以返回 1 。
//
//
//
// 提示：
//
//
// n == flips.length
// 1 <= n <= 5 * 10⁴
// flips 是范围 [1, n] 中所有整数构成的一个排列
//
// Related Topics 数组 👍 51 👎 0
public class NumTimesAllBlue {

    public static void main(String[] args) {
        NumTimesAllBlue ntab = new NumTimesAllBlue();
        int[] flips = new int[]{4,1,2,3};
        System.out.println(ntab.numTimesAllBlue(flips));
    }
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        StringBuffer sb =new StringBuffer();
        for(int i = 1;i <= n;i++){
            sb.append('0');
        }
        int count = 0;
        for(int i = 0;i < n;i++){
            int t = flips[i];
            sb.setCharAt(t-1,'1');
            if(isPre(sb.toString().substring(0,i+1))){
                count++;
            }
        }
        return count;
    }

    public boolean isPre(String str){
        return !str.contains("0");
    }

    public int numTimesAllBlue2(int[] flips) {
        int max = 0, ans = 0;
        for (int i = 0; i < flips.length; ++i) {
            if (max < flips[i]){

                max = flips[i];
            }
            if (i + 1 == max){
                ans++; // 注意i的下标是从0开始的
            }
        }
        return ans;
    }

}
