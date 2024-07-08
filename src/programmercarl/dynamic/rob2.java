package programmercarl.dynamic;

import programmercarl.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class rob2 {
    List<Integer> list = new ArrayList<>();

    public int rob(TreeNode root) {
        getRoomList(root);
        int[][] dp = new int[list.size() + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = list.get(0);
        for (int i = 2; i <= list.size(); i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1]));
        }
        return Math.max(dp[list.size()][0], dp[list.size()][1]);
    }

    private void getRoomList(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    list.add(null);
                    continue;
                }
                list.add(poll.val);
                if (poll.left != null || poll.right != null) {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }

        }
    }
}
