package dynamic;

import java.util.Arrays;
import java.util.Map;

public class findLengthOfLCIS {
    public static void main(String[] args) {

    }

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max == Integer.MIN_VALUE ? 1 : max;

    }
}
