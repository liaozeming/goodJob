package programmercarl.other;

public class balancedStringSplit {
    public int balancedStringSplit(String s) {
        int leftCount = 0;
        int rightCount = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
                sum++;
            }
        }
        return sum;
    }
}
