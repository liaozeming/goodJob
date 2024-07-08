package programmercarl.tree;

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeDfs(root);
        return root;
    }

    private void invertTreeDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
    }
}
