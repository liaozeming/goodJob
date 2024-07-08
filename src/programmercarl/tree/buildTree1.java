package programmercarl.tree;

public class buildTree1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int length = preorder.length - 1;
        return buildTreeOrder(preorder, 0, length, inorder, 0, length);
    }

    private TreeNode buildTreeOrder(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        int headValue = preorder[preLeft];
        int index = getIndex(inorder, headValue);
        TreeNode root = new TreeNode(inorder[index]);
        // 左子树的个数
        // index-inLeft
        // 右子树的个数
        // inRight - index
        root.left = buildTreeOrder(preorder, preLeft + 1, index - inLeft + preLeft, inorder, inLeft, index - 1);
        root.right = buildTreeOrder(preorder, preRight - inRight + index + 1, preRight, inorder, index + 1, inRight);
        return root;
    }

    private int getIndex(int[] inorder, int headValue) {
        for (int i = 0; i < inorder.length; i++) {
            if (headValue == inorder[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        buildTree1 buildTree1 = new buildTree1();
        TreeNode treeNode = buildTree1.buildTree(preorder, inorder);
    }
}
