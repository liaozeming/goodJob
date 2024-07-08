package programmercarl.greedy;

import java.util.Arrays;

public class wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        // 以第i位置结尾的最长摆动序列 二维表示正负向摆动
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }
        // dp[i][0] = Math.max(dp[k][1] +1)  k<i  nums[i] > nums[k]
        // dp[i][1] = Math.max(dp[k][0] +1)  k<i  nums[i] < nums[k]
        for (int i = 1; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[i] > nums[k]) {
                    dp[i][0] = Math.max(dp[k][1] + 1, dp[i][0]);
                }
                if (nums[i] < nums[k]) {
                    dp[i][1] = Math.max(dp[k][0] + 1, dp[i][1]);
                }
                if (nums[i] == nums[k]) {
                    dp[i][0] = Math.max(dp[i][0], dp[k][0]);
                    dp[i][1] = Math.max(dp[i][1], dp[k][1]);
                }
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        wiggleMaxLength wiggleMaxLength = new wiggleMaxLength();
        int i = wiggleMaxLength.wiggleMaxLength(nums);
        System.out.println(i);
    }
}
