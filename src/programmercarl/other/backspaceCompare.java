package programmercarl.other;

import java.util.Stack;

public class backspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        return getBackspace(s).equals(getBackspace(t));
    }

    private String getBackspace(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                index++;
            } else {
                stack.push(s.charAt(index++));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        backspaceCompare backspaceCompare = new backspaceCompare();
        backspaceCompare.backspaceCompare("a##c", "#a#c");
    }
}
