package programmercarl.tree;

public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-2147483648);
        TreeNode treeNode1 = new TreeNode(2147483647);
        treeNode.right = treeNode1;
        isValidBST isValidBST = new isValidBST();
        isValidBST.isValidBST(treeNode);
    }

}
