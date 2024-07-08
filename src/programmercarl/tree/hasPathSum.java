package programmercarl.tree;

public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int leftValue) {
        if (root.left == null && root.right == null && leftValue == root.val) {
            return true;
        }
        if (root.left == null && root.right == null && leftValue != root.val) {
            return false;
        }
        boolean left = false;
        if (root.left != null) {
            left = dfs(root.left, leftValue - root.val);
        }
        boolean right = false;
        if (root.right != null) {
            right = dfs(root.right, leftValue - root.val);
        }
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
        hasPathSum hasPathSum = new hasPathSum();
        hasPathSum.hasPathSum(treeNode, 6);
    }
}
