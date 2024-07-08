package practice.其他;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class sortTree {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null){
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek != null) {
                stack.pop();
                if (peek.right != null) {
                    stack.push(peek.right);
                }
                stack.push(peek);
                stack.push(null);
                if (peek.left != null) {
                    stack.push(peek.left);
                }
            } else {
                stack.pop();
                TreeNode resultNode = stack.peek();
                stack.pop();
                list.add(resultNode.val);
            }
        }
        return list;
    }
}
