package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class combine {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(1, temp, n, k);
        return res;
    }

    private void backtrack(int index, List<Integer> temp, int n, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (n - index + 1 + temp.size() < k) {
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            backtrack(i + 1, temp, n, k);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        combine combine = new combine();
        List<List<Integer>> combine1 = combine.combine(4, 2);

    }
}
