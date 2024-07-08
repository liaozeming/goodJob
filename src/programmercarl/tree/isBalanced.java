package programmercarl.tree;

public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.right), getMaxDepth(root.left)) + 1;
    }

}
