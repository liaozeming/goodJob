package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class findSubsequences {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        int index = 0;
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(index, nums, temp, used);
        return res;
    }

    private void backTrack(int index, int[] nums, List<Integer> temp, boolean[] used) {
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            if (temp.isEmpty() || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                used[i] = true;
                backTrack(i + 1, nums, temp, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 3, 2, 1};
        findSubsequences findSubsequences = new findSubsequences();
        List<List<Integer>> subsequences = findSubsequences.findSubsequences(nums);
    }
}
