package programmercarl.stack;

import java.util.Stack;

public class evalRPN {
    public int evalRPN(String[] tokens) {
        int sum = 0;
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                int pop = Integer.parseInt(stack.pop());
                int pop1 = Integer.parseInt(stack.pop());
                if (token.equals("+")) {
                    sum = pop + pop1;
                    stack.push(String.valueOf(sum));
                    continue;
                }
                if (token.equals("-")) {
                    sum = pop1 - pop;
                    stack.push(String.valueOf(sum));
                    continue;
                }
                if (token.equals("/")) {
                    sum = pop1 / pop;
                    stack.push(String.valueOf(sum));
                    continue;
                }
                sum = pop * pop1;
                stack.push(String.valueOf(sum));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
