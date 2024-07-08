package programmercarl.singleStack;

import java.util.Stack;

public class trap {
    public int trap(int[] height) {
        int sum = 0;
        // 维护一个单调递减的栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer pop = stack.pop();
                if (!stack.isEmpty()) {
                    sum += (Math.min(height[stack.peek()], height[i]) - height[pop]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
