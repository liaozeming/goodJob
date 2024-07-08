package programmercarl.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        long curMax = Long.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > curMax) {
                count++;
                curMax = points[i][1];
            }
        }
        return count;
    }
}
