package programmercarl.greedy;

import java.util.Arrays;

public class canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        // 剩下的
        int cur = 0;
        // 起始位置
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (cur + gas[i] - cost[i] < 0) {
                cur = 0;
                start = i + 1;
            } else {
                cur += gas[i] - cost[i];
            }
        }
        return total >= 0 ? start : -1;
    }
}
