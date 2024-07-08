package programmercarl.stack;

import java.util.Stack;

public class isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        int left = 0;
        while (left < length) {
            char c = s.charAt(left);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if ((pop == '(' && c != ')') || (pop == '{' && c != '}')
                        || (pop == '[' && c != ']')) {
                    return false;
                }
            }
            left++;
        }
        return stack.isEmpty();
    }
}
