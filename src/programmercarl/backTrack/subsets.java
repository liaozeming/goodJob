package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int index = 0;
        List<Integer> temp = new ArrayList<>();
        backTrack(index, nums, temp);
        return list;
    }

    private void backTrack(int index, int[] nums, List<Integer> temp) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(i + 1, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
