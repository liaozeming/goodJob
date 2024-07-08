package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int index = 0;
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(index, nums, temp, used);
        return list;
    }

    private void backTrack(int index, int[] nums, List<Integer> temp, boolean[] used) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            backTrack(i + 1, nums, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        subsetsWithDup subsetsWithDup = new subsetsWithDup();
        List<List<Integer>> res = subsetsWithDup.subsetsWithDup(nums);
    }
}
