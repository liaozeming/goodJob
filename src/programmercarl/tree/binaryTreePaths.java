package programmercarl.tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    List<String> list;

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        binaryTreePath(root, "");
        return list;
    }

    private void binaryTreePath(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            s = s + root.val;
            list.add(s);
            return;
        }
        String t = s + root.val + "->";
        if (root.left != null) {
            binaryTreePath(root.left, t);
        }
        if (root.right != null) {
            binaryTreePath(root.right, t);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode4;
        binaryTreePaths binaryTreePaths = new binaryTreePaths();
        binaryTreePaths.binaryTreePaths(treeNode);
    }
}
