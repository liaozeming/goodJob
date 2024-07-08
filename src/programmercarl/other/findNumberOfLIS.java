package programmercarl.other;

import java.util.Arrays;

public class findNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int count = 0;
        //最大长度
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            // 当前最大长度
            int curMax = 1;
            int curCount = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] > curMax) {
                    curMax = dp[i];
                    curCount = 1;
                } else if (dp[i] == curMax) {
                    curCount++;
                }
            }
            if (curMax > max) {
                count = curCount;
                max = curMax;
            } else if (curMax == max) {
                count += curCount;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2};
        findNumberOfLIS findNumberOfLIS = new findNumberOfLIS();
        findNumberOfLIS.findNumberOfLIS(nums);
    }
}
