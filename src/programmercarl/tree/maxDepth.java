package programmercarl.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class maxDepth {
//    public int maxDepth(TreeNode root) {
//        int maxDepth = 0;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        if (root == null) {
//            return 0;
//        }
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            maxDepth++;
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null) {
//                    queue.add(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.add(poll.right);
//                }
//            }
//        }
//        return maxDepth;
//    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
