package programmercarl.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sortNums[0], 0);
        for (int i = 1; i < sortNums.length; i++) {
            if (sortNums[i] > sortNums[i - 1]) {
                map.put(sortNums[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7};
        smallerNumbersThanCurrent smallerNumbersThanCurrent = new smallerNumbersThanCurrent();
        int[] res = smallerNumbersThanCurrent.smallerNumbersThanCurrent(nums);
    }
}
