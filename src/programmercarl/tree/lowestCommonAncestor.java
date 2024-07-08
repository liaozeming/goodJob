package programmercarl.tree;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        boolean pIn = isInTreeNode(root.left, p);
        boolean qIn = isInTreeNode(root.right, q);
        if (pIn && qIn) {
            return root;
        }
        if (pIn && !qIn) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (!pIn && qIn) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean isInTreeNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return isInTreeNode(root.left, p) || isInTreeNode(root.right, p);
    }
}
