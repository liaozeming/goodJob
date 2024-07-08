package programmercarl.tree;

import java.util.ArrayList;
import java.util.List;

public class findMode {
    int count = 1;
    List<Integer> res = new ArrayList<>();
    TreeNode pre;
    int tempCount = 1;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        traversal(root);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traversal(root.left);
        //中
        if (pre != null) {
            if (root.val == pre.val) {
                tempCount++;
            }
            if (tempCount == count) {
                res.add(root.val);
            }
            if (tempCount > count) {
                res = new ArrayList<>();
                res.add(root.val);
            }
        }
        pre = root;
        //右
        traversal(root.right);
    }
}
