package link;

/**
 * @Description SwapPairs 24.两两交换链表中的节点 中等
 * @Author chengj
 * @Date 2022/1/20
 */
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
// Related Topics 递归 链表 👍 1231 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class SwapPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        System.out.println(swapPairs(l1));
    }
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode singleList = new ListNode(0);
        ListNode singleCurr = singleList;
        ListNode doubleList = new ListNode(0);
        ListNode doubleCurr = doubleList;
        int i = 1;
        while (head != null){
            if (i%2 ==1){
                singleCurr.next = new ListNode(head.val);
                singleCurr = singleCurr.next;
            }else {
                doubleCurr.next = new ListNode(head.val);
                doubleCurr = doubleCurr.next;
            }
            i++;
            head = head.next;
        }
        singleCurr = singleList.next;
        doubleCurr = doubleList.next;
        ListNode result = new ListNode(0);
        ListNode resultCurr = result;
        int j = 0;
        while (singleCurr != null || doubleCurr != null){
            if (j%2 ==0){
                if (doubleCurr != null){
                    resultCurr.next = new ListNode(doubleCurr.val);
                    doubleCurr = doubleCurr.next;
                    resultCurr = resultCurr.next;
                }

            }else {
                if (singleCurr != null) {
                    resultCurr.next = new ListNode(singleCurr.val);
                    singleCurr = singleCurr.next;
                    resultCurr = resultCurr.next;
                }
            }
            j++;

        }

        return result.next;
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode curr = result;
        while (curr.next !=  null && curr.next.next != null){
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next;
            curr.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            curr = node1;
        }

        return result.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
