package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int index = 0;
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, temp, used);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            backTrack(nums, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
