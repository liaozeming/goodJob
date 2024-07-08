package programmercarl.tree;

public class insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.left == null && val < root.val) {
            root.left = new TreeNode(val);
            return root;
        }
        if (root.right == null && val > root.val) {
            root.right = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
