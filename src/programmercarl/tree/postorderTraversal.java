package programmercarl.tree;

import java.util.ArrayList;
import java.util.List;

public class postorderTraversal {
    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        postorder(root);
        return res;
    }

    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        res.add(root.val);
    }
}
