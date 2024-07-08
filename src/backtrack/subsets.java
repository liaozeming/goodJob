package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets subsets = new subsets();
        List<List<Integer>> res = subsets.subsets(nums);
        for (List<Integer> next : res) {
            next.forEach(System.out::print);
            System.out.println("");
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path, int height) {
        if (height == nums.length) {
            return;
        }
        res.add(new ArrayList<>(path));
        for (int i = height; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, path, height+1);
            path.remove(path.size() - 1);
        }
    }

}
