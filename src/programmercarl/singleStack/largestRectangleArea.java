package programmercarl.singleStack;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = -1;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        newHeights[newHeights.length - 1] = -1;
        int area = 0;
        // 维护一个单调递增的栈
        // 左边是小于当前的高度  找到右边小于自己高度的位置
        //即中间全部的高度都是大于等于自己的高度 面积就以自己为高 宽度即左右小于自己高度距离-2
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int pop = stack.pop();
                int height = newHeights[pop];
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    area = Math.max(area, height * (i - left - 1));
                }
            }
            stack.push(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        largestRectangleArea largestRectangleArea = new largestRectangleArea();
        int i = largestRectangleArea.largestRectangleArea(heights);
        System.out.println(i);
    }
}
