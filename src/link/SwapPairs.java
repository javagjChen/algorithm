package link;

/**
 * @Description SwapPairs
 * @Author chengj
 * @Date 2022/1/20
 */
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


    public static ListNode swapPairs2(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode tmp = result;
        while (tmp.next !=  null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
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
