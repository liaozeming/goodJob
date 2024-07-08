package programmercarl.other;

import java.util.Arrays;

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    // 交换
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    // [i + 1, nums.length) 内元素升序排序
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums); // 不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    }
}
