package programmercarl.other;

public class sumNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }

    private void dfs(TreeNode root, String pre) {
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(pre + root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, pre + root.val);
        }
        if (root.right != null) {
            dfs(root.right, pre + root.val);

        }
    }
}
