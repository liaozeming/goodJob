package dynamic;

import java.util.Arrays;

public class combinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        combinationSum4 combinationSum4 = new combinationSum4();
        int i = combinationSum4.combinationSum4(nums, target);
        System.out.println(i);
    }

    public int combinationSum4(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum || sum < -1 * target) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }            }
        }
        return dp[target];
    }
}
