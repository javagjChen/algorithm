package link;

/**
 * @author chengj
 * @Description 19.删除链表的倒数第N个结点 中等
 * @Date 2022/2/23
 */
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1809 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd.removeNthFromEnd2(l1,1));
    }
    // 倒数第N个就是，顺数第len-N 个
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode curr = head;
        int len = 0;
        while (curr != null){
            curr = curr.next;
            len++;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        curr = hair;
        int t = len-n;
        // 1,2,3,4,5
        while (t > 0){
            curr = curr.next;
            t--;
        }
        curr.next = curr.next.next;
        return hair.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode slow = tmp;
        ListNode fast = tmp;
        //快指针先走N步
        for (int i =0;i < n;i++){
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
