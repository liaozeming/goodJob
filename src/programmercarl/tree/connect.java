package programmercarl.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class connect {
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if (root == null) {
            return root;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = queue.poll();
            if (pre.left != null) {
                queue.add(pre.left);
            }
            if (pre.right != null) {
                queue.add(pre.right);
            }
            Node cur;
            for (int i = 1; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                pre.next = cur;
                pre = cur;
            }
        }
        return root;
    }
}
