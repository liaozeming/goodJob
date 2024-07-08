package programmercarl.other;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int firstVal = head.val;
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        boolean isPalindrome = firstVal == temp.next.val;
        temp.next = null;
        return isPalindrome && isPalindrome(head.next);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        isPalindrome isPalindrome = new isPalindrome();
        isPalindrome.isPalindrome(listNode1);
    }
}
