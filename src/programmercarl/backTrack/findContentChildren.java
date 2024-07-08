package programmercarl.backTrack;

import java.util.Arrays;

public class findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int childIndex = 0;
        int cookIndex = 0;
        int max = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (childIndex < g.length && cookIndex < s.length) {
            if (g[childIndex] <= s[cookIndex]) {
                max++;
                childIndex++;
            }
            cookIndex++;
        }
        return max;
    }
}
