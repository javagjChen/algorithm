package monotony;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author chengj
 * @Description 739.每日温度 中等
 * @Date 2022/4/25
 */
//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
// Related Topics 栈 数组 单调栈 👍 1122 👎 0
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int [] temperatures = new int[]{30,60,90};
        System.out.println(Arrays.toString(dt.dailyTemperatures2(temperatures)));
    }

    /**
     * 暴力解法
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        for (int i = 0;i < temperatures.length;i++){
            for (int j = i + 1;j < temperatures.length;j++){
                if (temperatures[j] > temperatures[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 单调栈解法
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1;i < temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
