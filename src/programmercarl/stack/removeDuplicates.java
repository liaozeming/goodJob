package programmercarl.stack;

import java.util.Stack;

public class removeDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        removeDuplicates removeDuplicates = new removeDuplicates();
        String s = removeDuplicates.removeDuplicates("abbaca");
        System.out.println(s);
    }
}
