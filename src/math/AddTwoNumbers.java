package math;

/**
 * @Description 两数相加
 * @Author chengj
 * @Date 2022/1/4
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        System.out.println(addTwoNumbers(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode curr = result;
        int flagVal = 0;
        while (l1 != null || l2 != null){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int tmp = l1Val + l2Val + flagVal;
            if (tmp >= 10){
                flagVal = 1;
                tmp = tmp - 10;
            }else {
                flagVal = 0;
            }
            ListNode tmpNode = new ListNode(tmp);
            curr.next = tmpNode;
            curr = curr.next;
            if (l2 != null){
                l2 = l2.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
        }
        if (flagVal != 0 ){
            curr.next = new ListNode(flagVal);
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

