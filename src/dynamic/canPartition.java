package dynamic;

import java.util.Arrays;

public class canPartition {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        canPartition canPartition = new canPartition();
        boolean b = canPartition.canPartition1(nums);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        boolean[][] partition = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            partition[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums[i - 1]; j <= sum; j++) {
                partition[i][j] = partition[i - 1][j] || partition[i - 1][j - nums[i - 1]];
            }
        }
        return partition[nums.length][sum];
    }

    boolean[] choose;

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int halfSum = sum / 2;
        this.choose = new boolean[nums.length];
        return partitionBackTrack(nums, halfSum);
    }

    private boolean partitionBackTrack(int[] nums, int halfSum) {
        if (halfSum == 0) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (choose[i]) {
                continue;
            }
            choose[i] = true;
            if (halfSum - nums[i] >= 0) {
                boolean partitionBackTrack = partitionBackTrack(nums, halfSum - nums[i]);
                if (partitionBackTrack) {
                    return true;
                }
            }
            choose[i] = false;
        }
        return false;
    }
}
