package programmercarl.greedy;

public class lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount == 0) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else if (bills[i] == 20) {
                if (tenCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else {
                    fiveCount -= 3;
                }
                if (fiveCount < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
