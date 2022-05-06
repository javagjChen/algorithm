package company;

/**
 * @author chengj
 * @Description
 * @Date 2022/5/6
 */
public class ExchangeNodes {

    public static void main(String[] args) {
        ExchangeNodes exchangeNodes = new ExchangeNodes();
        ListNode curr = new ListNode(1);
//        curr.next = new ListNode(2);
//        curr.next.next = new ListNode(3);
//        curr.next.next.next = new ListNode(4);
//        curr.next.next.next.next = new ListNode(5);
        exchangeNodes.exchangeNodes(curr,1);
    }

    public ListNode exchangeNodes(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode curr = ans;
        int len = 0;
        while (curr.next != null){
            curr = curr.next;
            len++;
        }
        curr = ans;
        for (int i =0;i<=k-1;i++){
            curr = curr.next;
        }

        ListNode node1 = curr;
        curr = ans;
        for (int i =0;i<=len-k;i++){
            curr = curr.next;
        }
        ListNode node2 = curr;

        if (node2 != null && node1 != null){
            int tmp = node2.val;
            node2.val = node1.val;
            node1.val = tmp;
        }

        return ans.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
