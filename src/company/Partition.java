package company;


/**
 * @author chengj
 * @Description 86.分隔链表 中等 03
 * @Date 2022/4/18
 */
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [2,1], x = 2
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 200] 内
// -100 <= Node.val <= 100
// -200 <= x <= 200
//
// Related Topics 链表 双指针 👍 548 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Partition {

    public static void main(String[] args) {
        Partition partition = new Partition();
        ListNode curr = new ListNode(4);
        curr.next = new ListNode(1);
        curr.next.next = new ListNode(3);
        curr.next.next.next = new ListNode(2);
        curr.next.next.next.next = new ListNode(5);
        curr.next.next.next.next.next = new ListNode(2);
        partition.partition(curr,3);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode ans = null;
        ListNode ansCurr = null;
        ListNode sAns = null;
        ListNode sAnsCurr = null;
        ListNode curr = head;
        while (curr != null){
            int val = curr.val;
            if (val >= x){
                if (ans == null){
                    ans = new ListNode(val);
                    ansCurr = ans;
                }else {
                    ansCurr.next = new ListNode(val);
                    ansCurr = ansCurr.next;
                }
            }else {
                if (sAns == null){
                    sAns = new ListNode(val);
                    sAnsCurr = sAns;
                }else {
                    sAnsCurr.next = new ListNode(val);
                    sAnsCurr = sAnsCurr.next;
                }
            }
            curr = curr.next;
        }
        if (sAns == null){
            return ans;
        }
        sAnsCurr.next = ans;
        return sAns;
    }

    private static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
