package programmercarl.dynamic;

public class rob {
    public int rob(int[] nums) {
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
        int[] nums = {2, 1, 1, 2};
        rob rob = new rob();
        int rob1 = rob.rob(nums);
    }
}
