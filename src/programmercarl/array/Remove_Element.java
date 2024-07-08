package programmercarl.array;

public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow++] = nums[fast++];
            }else {
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        Remove_Element removeElement = new Remove_Element();
        int i = removeElement.removeElement(nums, val);
        System.out.println(i);
    }
}
