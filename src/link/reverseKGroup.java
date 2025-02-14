package link;

/**
 * @Description 25.K个一组翻转链表 困难
 * @Author chengj
 * @Date 2022/1/24
 */
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 进阶：
//
//
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
// 示例 3：
//
//
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
//
//
// 示例 4：
//
//
//输入：head = [1], k = 1
//输出：[1]
//
//
//
//
//
// 提示：
//
//
// 列表中节点的数量在范围 sz 内
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
// Related Topics 递归 链表 👍 1448 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class reverseKGroup {

    // 1,2,3,4,5
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        ListNode end = hair;
        while (end.next != null){
            // 找到结束节点
            for (int i =0 ;i < k && end != null;i++){
                end = end.next;
            }
            // 省下的长度不够K则不需要再翻转了
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            //保存翻转前的节点
            ListNode next = end.next;
            // 端开
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return hair.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
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
