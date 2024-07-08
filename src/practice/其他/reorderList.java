package practice.其他;

public class reorderList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reorderList reorderList = new reorderList();
        reorderList.reorderList(listNode1);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }

    }

    public void reorderList(ListNode head) {
        reorder(head);
    }

    private ListNode reorder(ListNode head) {
        //保证有3个
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //倒数第二个节点
        ListNode tail = head;
        while (tail.next != null && tail.next.next != null) {
            tail = tail.next;
        }
        ListNode end = tail.next;
        tail.next = null;
        ListNode temp = head.next;
        head.next = end;
        end.next = reorder(temp);
        return head;
    }
}
