package link;

/**
 * @Description 合并K个升序链表
 * @Author chengj
 * @Date 2022/1/17
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        int len = lists.length;
        if (len == 1){
            return lists[0];
        }
        int i = 1;
        ListNode result =lists[0];
        while (i < len){
            result = mergeLists(result,lists[i]);
            i++;
        }
        return result;
    }

    public ListNode mergeLists(ListNode link1,ListNode link2){
        if (link1 == null){
            return link2;
        }
        if (link2 == null){
            return link1;
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (link1 != null && link2 != null){
            if (link1.val <= link2.val){
                cur.next = link1;
                link1 = link1.next;
            }else {
                cur.next = link2;
                link2 = link2.next;
            }
            cur = cur.next;
        }
        if (link1 != null){
            cur.next = link1;
        }
        if (link2 != null){
            cur.next = link2;
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
