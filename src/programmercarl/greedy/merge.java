package programmercarl.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int curMax = intervals[0][1];
        int left = intervals[0][0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curMax) {
                // 重叠
                left = Math.min(left, intervals[i][0]);
                curMax = Math.max(intervals[i][1], curMax);
            } else {
                res.add(new int[]{left, curMax});
                left = intervals[i][0];
                curMax = intervals[i][1];
            }
        }
        res.add(new int[]{left, curMax});
        return res.toArray(new int[0][]);
    }
}
