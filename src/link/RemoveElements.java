package link;

/**
 * @author chengj
 * @Description 移除链表元素 简单
 * @Date 2022/2/22
 */
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 809 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class RemoveElements {
    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(removeElements.removeElements(l1,2));
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode curr = ans;
        while ( curr.next != null){
            if (curr.next.val == val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return ans.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
