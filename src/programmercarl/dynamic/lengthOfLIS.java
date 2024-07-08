package programmercarl.dynamic;

import java.util.Arrays;

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 以nums[i] 结尾的最大子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS lengthOfLIS = new lengthOfLIS();
        int i = lengthOfLIS.lengthOfLIS(nums);
        System.out.println(i);
    }
}
