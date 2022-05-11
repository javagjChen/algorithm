package link;

/**
 * @Description 61.旋转链表 中等
 * @Author chengj
 * @Date 2022/1/29
 */

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 10⁹
//
// Related Topics 链表 双指针 👍 714 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (k ==0 || head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }
        // 组成环
        tail.next = head;
        // 1,2,3,4,5  k =2
        // 4,5,1,2,3
        ListNode newHead,newTail = head;
        k = k %len;
        // 找到断开位置
        for (int i = 0;i < (len -1 - k);i++){
            newTail = newTail.next;
        }
        // 新的头结点指向断开环的位置
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
