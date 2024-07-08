package programmercarl.link;

public class MyLinkedList {
    ListNode dummy;
    int length;

    public MyLinkedList() {
        dummy = new ListNode();
        length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = dummy.next;
        dummy.next = listNode;
        length++;
    }

    public void addAtTail(int val) {
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
        }
        ListNode listNode = new ListNode(val);
        listNode.next = cur.next;
        cur.next =listNode;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode listNode = new ListNode(val);
        listNode.next = cur.next;
        cur.next = listNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index >= length) {
            return;
        }
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        length--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtTail(7);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtHead(0);
        myLinkedList.get(5);
        myLinkedList.addAtHead(0);
        myLinkedList.get(2);
        myLinkedList.get(5);
        myLinkedList.addAtTail(4);

    }
}
