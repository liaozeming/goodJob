package programmercarl.array;

public class squares_sort {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        int index = right;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[index] = nums[right] * nums[right];
                right--;
            } else {
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return res;
    }
}
