package link;

/**
 * @Description 23.合并K个升序链表 困难
 * @Author chengj
 * @Date 2022/1/17
 */
//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1745 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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

    // 合并两个链表
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
