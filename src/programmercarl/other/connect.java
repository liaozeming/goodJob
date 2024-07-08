package programmercarl.other;

import java.util.ArrayDeque;
import java.util.Queue;

public class connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
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
            for (int i = 1; i < size; i++) {
                Node cur = queue.poll();
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

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        connect connect = new connect();
        connect.connect(node1);
    }
}
