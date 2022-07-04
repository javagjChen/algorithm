package weekgame;

import link.RemoveNthFromEnd;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/3
 */
public class SpiralMatrix {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];


        ListNode curr = head;

        int top =0,left =0,right = n-1,bottom = m-1;
        while (top <= bottom && left <= right){
            // 向右
            for (int column = left;column <= right;column ++){
                if (curr != null){
                    ans[top][column] = curr.val;
                    curr = curr.next;
                }else {
                    ans[top][column] = -1;
                }
            }
            // 向下
            for (int row = top + 1;row <= bottom;row ++){
                if (curr != null){
                    ans[row][right] = curr.val;
                    curr = curr.next;
                }else {
                    ans[row][right] = -1;
                }
            }
            if (top < bottom && left < right){
                // 向左
                for (int column = right-1;column >= left;column --){
                    if (curr != null){
                        ans[bottom][column] = curr.val;
                        curr = curr.next;
                    }else {
                        ans[bottom][column] = -1;
                    }
                }
                // 向上
                for (int row = bottom -1;row >= top +1;row--){
                    if (curr != null){
                        ans[row][left] = curr.val;
                        curr = curr.next;
                    }else {
                        ans[row][left] = -1;
                    }
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return ans;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
