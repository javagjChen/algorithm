package partice;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/26
 */
public class MergeInBetween {

    public static void main(String[] args) {
        MergeInBetween mib = new MergeInBetween();

        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1000);
        list2.next = new ListNode(1001);
        list2.next.next = new ListNode(1002);
        mib.mergeInBetween(list1,3,4,list2);

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode curr = head;
        int index = 0;
        while(curr != null){
            index++;
            while (index != a ){
                curr = curr.next;
                index++;
            }
            ListNode newCurr = curr.next;
            curr.next = list2;
            curr = curr.next;
            while (index != b + 1){
                newCurr = newCurr.next;
                index++;
            }
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newCurr;
            break;
        }
        return  head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
}
