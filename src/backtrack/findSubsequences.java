package backtrack;

import java.util.*;

public class findSubsequences {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        findSubsequences findSubsequences = new findSubsequences();
        List<List<Integer>> subsequences = findSubsequences.findSubsequences(nums);
        for (List<Integer> next : subsequences) {
            next.forEach(System.out::print);
            System.out.println();
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return res;
        }
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path, int index) {
        if (index > nums.length) {
            return;
        }
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet();
        for (int i = index; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, path, i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
