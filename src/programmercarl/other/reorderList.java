package programmercarl.other;

public class reorderList {
    public void reorderList(ListNode head) {
        reorderNode(head);
    }

    private ListNode reorderNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode next = head.next;
        // temp 倒数第二个结点
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        head.next = temp.next;
        temp.next = null;
        head.next.next = reorderNode(next);
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        reorderList reorderList = new reorderList();
        reorderList.reorderList(listNode1);
    }
}
