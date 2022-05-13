package link;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description 82.删除排序链表中的重复元素2 中等
 * @Date 2022/5/11
 */
//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,2,3]
//输出：[2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
// Related Topics 链表 双指针 👍 885 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates dd = new DeleteDuplicates();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
       // l1.next.next.next = new ListNode(2);
//        l1.next.next.next.next = new ListNode(5);
        System.out.println(dd.deleteDuplicates2(l1));
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode ans = new ListNode(-101);
        ans.next = head;
        ListNode curr = ans;
        while (curr.next != null && curr.next.next != null){
            if (curr.next.val == curr.next.next.val) {
                int t = curr.next.val;
                while (curr.next != null && curr.next.val == t) {
                    curr.next = curr.next.next;
                }
            }else {
                curr = curr.next;
            }
        }
        return ans.next;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null){
            map.put(curr.val,map.getOrDefault(curr.val,0) + 1);
            curr = curr.next;
        }
        ListNode ans = new ListNode(-101);
        ans.next = head;
        curr = ans;
        while (curr != null ){
            while (curr.next != null && map.get(curr.next.val) > 1) {
                curr.next = curr.next.next;
            }
            curr = curr.next;

        }
        return ans.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
