package monotony;

import java.util.Stack;

/**
 * @author chengj
 * @Description 84.柱状图中的最大的矩形 困难
 * @Date 2022/4/18
 */
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
// 示例 1:
//
//
//
//
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//
//
// 示例 2：
//
//
//
//
//输入： heights = [2,4]
//输出： 4
//
//
//
// 提示：
//
//
// 1 <= heights.length <=10⁵
// 0 <= heights[i] <= 10⁴
//
// Related Topics 栈 数组 单调栈 👍 1882 👎 0

public class LargestRectangleArea {

    public static void main(String[] args) {
        LargestRectangleArea lra = new LargestRectangleArea();
        System.out.println(lra.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int[] copy = new int[heights.length + 2];
        for (int i = 0;i < heights.length;i++){
            copy[i+1] = heights[i];
        }
        copy[0] = copy[heights.length + 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i =1;i < copy.length;i++){
            while (copy[i] < copy[stack.peek()]){
                int top = stack.pop();
                int h = copy[top];
                int w = i - stack.peek() - 1;
                ans = Math.max(ans,h * w);

            }
            stack.push(i);
        }
        return ans;
    }
}
