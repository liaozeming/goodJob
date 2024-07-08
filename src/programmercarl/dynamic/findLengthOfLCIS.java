package programmercarl.dynamic;

import java.util.Arrays;

public class findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        findLengthOfLCIS findLengthOfLCIS = new findLengthOfLCIS();
        int lengthOfLCIS = findLengthOfLCIS.findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }
}
