package programmercarl.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int curMax = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < curMax) {
                count++;
            } else {
                curMax = intervals[i][1];
            }
        }
        return count;
    }
}
