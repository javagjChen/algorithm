package weekgame;

/**
 * @author chengj
 * @Description 6037.按奇偶性交换后的最大数字 简单
 * @Date 2022/4/10
 */
//给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
//
// 返回交换 任意 次之后 num 的 最大 可能值。
//
//
//
// 示例 1：
//
// 输入：num = 1234
//输出：3412
//解释：交换数字 3 和数字 1 ，结果得到 3214 。
//交换数字 2 和数字 4 ，结果得到 3412 。
//注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
//注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
//
//
// 示例 2：
//
// 输入：num = 65875
//输出：87655
//解释：交换数字 8 和数字 6 ，结果得到 85675 。
//交换数字 5 和数字 7 ，结果得到 87655 。
//注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
//
//
//
//
// 提示：
//
//
// 1 <= num <= 10⁹
//
// 👍 6 👎 0
public class LargestInteger {
    public static void main(String[] args) {
        LargestInteger largestInteger = new LargestInteger();
        System.out.println(largestInteger.largestInteger(1234));
    }
    public int largestInteger(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int [] arr = new int[len];
        for (int i = 0;i < len;i++){
            arr[i] = str.charAt(i) -48;
        }
        if (len ==1){
            return num;
        }
        for (int i = 0;i<len-1;i++){
            boolean flag = arr[i]%2==0?true:false;
            for (int j = i + 1;j < len;j++){
                if (flag == (arr[j]%2==0) && arr[j] > arr[i]){
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }


        }
        StringBuilder sb = new StringBuilder();
        for (int i :arr){
            sb.append(i+"");
        }
        return Integer.parseInt(sb.toString());
    }
}
