package programmercarl.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class minDepth {
//    public int minDepth(TreeNode root) {
//        int minDepth = 0;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        if (root == null) {
//            return 0;
//        }
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            minDepth++;
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                if (poll.left == null && poll.right == null) {
//                    return minDepth;
//                }
//                if (poll.left != null) {
//                    queue.add(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.add(poll.right);
//                }
//            }
//        }
//        return minDepth;
//    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }

}
