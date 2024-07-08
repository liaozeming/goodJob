package programmercarl.tree;

import java.util.ArrayList;
import java.util.List;

public class getMinimumDifference {
    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


}
