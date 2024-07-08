package practice.其他;

public class isSubPath {
    public static void main(String[] args) {

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head != null && root == null) {
            return false;
        }
        if (head == null) {
            return true;
        }
        if (root.val == head.val) {
            return isSubPath(head.next, root.left) || isSubPath(head.next, root.right) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
