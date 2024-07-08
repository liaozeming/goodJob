package programmercarl.dynamic;

import java.util.Arrays;

public class rob1 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] robNums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] robNums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robCircle(robNums1), robCircle(robNums2));
    }

    private int robCircle(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1]));
            dp[i][1] = Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 1][0]) + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public static void main(String[] args) {
        int[] nums = {0};
        rob1 rob = new rob1();
        int rob1 = rob.rob(nums);
    }
}
