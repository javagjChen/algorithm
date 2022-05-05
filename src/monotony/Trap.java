package monotony;

import java.util.Stack;

/**
 * @Description
 * @Author chengj 接雨水 困难
 * @Date 2022/2/7
 */
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3070 👎 0
public class Trap {

    /**
     * 双指针解法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int len = height.length;
        int left = 0,right = len -1;
        int maxLeft = 0,maxRight = 0;
        while (left < right){
            if (height[left] < height[right]){
                maxLeft = Math.max(maxLeft,height[left]);
                if (maxLeft > height[left]){
                    ans += (maxLeft - height[left]);
                }
                left++;
            }else {
                maxRight = Math.max(maxRight,height[right]);
                if (maxRight > height[right]){
                    ans += (maxRight - height[right]);
                }
                right--;
            }
        }
        return ans;
    }

    /**
     * 动态规划解法
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        maxLeft[0] = height[0];
        for (int i = 1;i < len;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        int[] maxRight = new int[len];
        maxRight[len-1] = height[len-1];
        for (int i = len -2;i >= 0;i--){
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        int ans = 0;
        for (int i = 1; i < len-1;i++){
            ans += (Math.min(maxLeft[i],maxRight[i]) - height[i]);
        }
        return ans;
    }

    /**
     * 单调栈解法
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < height.length;i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()], height[i]) - height[bottom];
                    int w = i - stack.peek() - 1;
                    ans += (h * w);
                }
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap3(new int[]{0,1}));
    }

}
