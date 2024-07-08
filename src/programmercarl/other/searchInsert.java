package programmercarl.other;

public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        return searchIndex(nums, target);
    }

    // 大于等于target的最小位置 小于所有的返回0 大于所有的返回nums.length
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
}
