package dynamic;

import java.util.Arrays;
import java.util.Map;

public class lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS lengthOfLIS = new lengthOfLIS();
        int i = lengthOfLIS.lengthOfLIS(nums);
        System.out.println(i);
    }

    /**
     * @param nums
     * @return int
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max == Integer.MIN_VALUE ? 1 : max;
    }
}
