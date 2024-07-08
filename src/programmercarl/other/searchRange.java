package programmercarl.other;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftIndex = searchIndex(nums, target);
        if (leftIndex >= nums.length || nums[leftIndex] != target) {
            return new int[]{-1, -1};
        }
        int rightIndex = searchIndex(nums, target + 1);
        return new int[]{leftIndex, rightIndex - 1};
    }

    // 大于等于target的最小位置
    // 循环不变量：
    // nums[left-1] < target
    // nums[right] >= target
    private int searchIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        searchRange searchRange = new searchRange();
        searchRange.searchRange(nums, 3);
    }
}
