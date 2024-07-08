package programmercarl.link;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        cur.next = pre;
        pre.next = swapPairs(next);
        return cur;
    }
}
