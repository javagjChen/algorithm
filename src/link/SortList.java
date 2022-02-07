package link;

/**
 * @Description 排序链表
 * @Author chengj
 * @Date 2022/1/24
 */
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
//
//
//
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1440 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class SortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        ListNode result = sortList(l1);
        System.out.println(result.toString());
    }
    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 循环结束slow来的中点
        // 分割点
        ListNode tmp = slow.next;
        // 分割
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode result = new ListNode(0);
        ListNode resultCurr = result;
        while (left != null && right != null){
            if (left.val <= right.val){
                resultCurr.next = left;
                left = left.next;
            }else {
                resultCurr.next = right;
                right = right.next;
            }
            resultCurr = resultCurr.next;
        }
        if (left != null){
            resultCurr.next = left;
        }
        if (right != null){
            resultCurr.next = right;
        }

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
