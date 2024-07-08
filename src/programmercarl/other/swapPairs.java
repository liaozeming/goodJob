package programmercarl.other;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        cur.next = head;
        head.next = swapPairs(next);
        return cur;
    }
}
