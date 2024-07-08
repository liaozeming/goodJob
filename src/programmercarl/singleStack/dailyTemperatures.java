package programmercarl.singleStack;

import java.util.Arrays;
import java.util.Stack;

public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        //维护一个单调递减的栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures dailyTemperatures = new dailyTemperatures();
        int[] ints = dailyTemperatures.dailyTemperatures(temperatures);
    }
}
