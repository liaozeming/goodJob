package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class permuteUnique {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, temp, used);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || hashSet.contains(nums[i])) {
                continue;
            }
            hashSet.add(nums[i]);
            temp.add(nums[i]);
            used[i] = true;
            backTrack(nums, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
