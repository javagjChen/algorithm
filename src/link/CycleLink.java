package link;

/**
 * @Description
 * @Author chengj
 * @Date 2022/1/11
 */
public class CycleLink {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if (slow != null){
                slow = slow.next;
            }else {
                return null;
            }
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if (slow == fast){
                ListNode ptr = head;
                while (slow != ptr){
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
