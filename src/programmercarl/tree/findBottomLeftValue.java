package programmercarl.tree;

public class findBottomLeftValue {
    int bottomLeftVal = 0;
    int maxHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        bottomLeftVal = root.val;
        dfs(root, 0);
        return bottomLeftVal;
    }

    private void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height > maxHeight) {
            maxHeight = height;
            bottomLeftVal = root.val;
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}
