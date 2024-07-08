package programmercarl.greedy;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] maxPosition = new int[26];
        for (int i = 0; i < s.length(); i++) {
            maxPosition[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        // 能到达的最大位置
        int curMax = maxPosition[s.charAt(0) - 'a'];
        for (int i = 1; i < s.length(); i++) {
            int max = maxPosition[s.charAt(i) - 'a'];
            if (i > curMax) {
                curMax = max;
                res.add(i - left);
                left = i;
            } else {
                curMax = Math.max(curMax, max);
            }
        }
        res.add(s.length() - res.stream().reduce(0, (a, b) -> a + b));
        return res;
    }

}
