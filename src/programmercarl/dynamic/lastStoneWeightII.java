package programmercarl.dynamic;

import java.util.Arrays;

public class lastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int halfSum = sum / 2;
        int[] dp = new int[halfSum + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = halfSum; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[halfSum] * 2;
    }
}
