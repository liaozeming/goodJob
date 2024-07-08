package programmercarl.singleStack;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                Integer pop = stack.pop();
                // 判断pop出的元素是否在num1存在
                int index = getIndex(nums1, nums2[pop]);
                if (index != -1) {
                    res[index] = nums2[i];
                }
            }
            stack.push(i);
        }
        return res;
    }

    private int getIndex(int[] nums1, int i) {
        for (int j = 0; j < nums1.length; j++) {
            if (nums1[j] == i) {
                return j;
            }
        }
        return -1;
    }
}
