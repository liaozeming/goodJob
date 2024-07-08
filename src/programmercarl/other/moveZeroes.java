package programmercarl.other;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
    /*public void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (right >= 0 && nums[right] == 0) {
                right--;
            }
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
    }*/

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes moveZeroes = new moveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}
