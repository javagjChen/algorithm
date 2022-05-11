package link;

/**
 * @author chengj 92.反转链表2 中等
 * @Description
 * @Date 2022/2/11
 */
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1153 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class ReverseBetween {
    //输入：head = [1,2,3,4,5], left = 2, right = 4
    //输出：[1,4,3,2,5]
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        reverseBetween(l1,2,4);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        ListNode end = hair;
        int index = 1;
        // 找到left的前一个节点
        while (index < left){
            index++;
            pre = pre.next;
            end = end.next;
        }
        // 切断出一个子链
        ListNode begin = pre.next;
        // 找到right节点
        // 1,2,3,4,5
        int len = right - left + 1;
        while (len > 0){
            len--;
            end = end.next;
        }
        ListNode leftList = end.next;

        // 切断
        end.next = null;
        // 反转
        pre.next = reverse(begin);;
        begin.next = leftList;

        return hair.next;
    }

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
