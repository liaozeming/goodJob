package programmercarl.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        int k = nums.length - 1;
        while (i < k) {
            int j = i + 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    list.add(temp);
                }
                j++;
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
            while (k >= 1 && nums[k] == nums[k - 1]) {
                k--;
            }
            k--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum threeSum = new threeSum();
        List<List<Integer>> list = threeSum.threeSum(nums);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).forEach(System.out::println);
        }
    }
}
