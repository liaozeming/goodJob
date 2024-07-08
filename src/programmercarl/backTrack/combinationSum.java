package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(0, candidates, 0, target, temp, used);
        return res;
    }

    private void backtrack(int index, int[] candidates, int curSum, int target, List<Integer> temp, boolean[] used) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (curSum + candidates[i] > target) break;
            if (i > 0 && !used[i - 1] && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            used[i] = true;
            backtrack(i + 1, candidates, curSum + candidates[i], target, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
