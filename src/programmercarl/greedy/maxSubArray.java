package programmercarl.greedy;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        // dp[i] 以i 结尾的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray maxSubArray = new maxSubArray();
        maxSubArray.maxSubArray(nums);
    }
}
