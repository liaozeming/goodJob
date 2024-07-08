package programmercarl.greedy;

public class canJump {
/*    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) {
                return false;
            }
            maxJump = Math.max(maxJump, nums[i] + i);
            if (maxJump >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }*/

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > dp[i - 1]) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            if (dp[i] >= nums.length - 1) {
                return true;
            }
        }
        return dp[nums.length - 1] >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        canJump canJump = new canJump();
        canJump.canJump(nums);
    }
}
