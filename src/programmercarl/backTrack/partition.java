package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class partition {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(0, s, temp);
        return res;
    }

    private void backtrack(int index, String s, List<String> temp) {
        if (index > s.length()) {
            return;
        }
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (!isSymmer(s, index, i)) {
                continue;
            }
            temp.add(s.substring(index, i + 1));
            backtrack(i + 1, s, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isSymmer(String s, int index, int i) {
        while (index < i) {
            if (s.charAt(index++) != s.charAt(i--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        partition partition = new partition() ;
        List<List<String>> aab = partition.partition("aab");
    }
}
