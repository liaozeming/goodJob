package programmercarl.tree;

public class buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int length = inorder.length - 1;
        return buildTreeOrder(inorder, 0, length, postorder, 0, length);
    }

    private TreeNode buildTreeOrder(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight){
            return null;
        }
        if (inLeft == inRight) {
            return new TreeNode(inorder[inLeft]);
        }
        int headValue = postorder[postRight];
        // 根结点位置
        int index = getIndex(inorder, headValue);
        TreeNode root = new TreeNode(inorder[index]);
        //左子树的结点数
        // int leftCount = index - inLeft;
        //右子树的结点数
        // int rightCount = inRight - index;
        root.left = buildTreeOrder(inorder, inLeft, index - 1, postorder, postLeft, postLeft + index - inLeft - 1);
        root.right = buildTreeOrder(inorder, index + 1, inRight, postorder, postRight - inRight + index, postRight - 1);
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
        int[] inorder = {2,1}, postorder = {2,1};
        buildTree buildTree = new buildTree();
        TreeNode treeNode = buildTree.buildTree(inorder, postorder);
    }
}
