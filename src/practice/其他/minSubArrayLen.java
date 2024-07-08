package practice.其他;

public class minSubArrayLen {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        minSubArrayLen minSubArrayLen = new minSubArrayLen();
        int i = minSubArrayLen.minSubArrayLen(target, nums);
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            while (sum < target) {
                sum += nums[right];
                right++;
            }
            minLength = Math.min(minLength, right - left + 1);
            while (sum >= target) {
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
