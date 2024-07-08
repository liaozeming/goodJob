package programmercarl.singleStack;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] nums_double = new int[nums.length * 2];
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums_double.length; i++) {
            nums_double[i] = nums[i % nums.length];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums_double.length; i++) {
            while (!stack.isEmpty() && nums_double[i] > nums_double[stack.peek()]) {
                int pop = stack.pop() % nums.length;
                if (res[pop] == -1) {
                    res[pop] = nums[i % nums.length];
                }
            }
            stack.push(i);
        }
        return res;
    }
}
