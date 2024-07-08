package practice.其他;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = lowerBound2(nums, target);
        if (nums[start] != target)
            return new int[]{-1, -1};
        int end = lowerBound3(nums, target);
        return new int[]{start, end};
    }

    private int lowerBound2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left; // 或者 right
    }


    private int lowerBound3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target)
                left = mid;
            else
                right = mid - 1; // 范围缩小到 [left, mid)
        }
        return left; // 或者 right
    }
}
