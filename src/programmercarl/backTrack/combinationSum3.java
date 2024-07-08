package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class combinationSum3 {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(1, temp, k, n, 0);
        return res;
    }

    private void backTrack(int index, List<Integer> temp, int k, int n, int sum) {
        if (sum > n) {
            return;
        }
        if (temp.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (n - index + 1 + temp.size() < k) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            temp.add(i);
            backTrack(i + 1, temp, k, n, sum + i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum3 combinationSum3 = new combinationSum3();
        List<List<Integer>> combine1 = combinationSum3.combinationSum3(3, 7);

    }
}
