package programmercarl.other;

import java.util.HashMap;
import java.util.Map;

public class isLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int left = 0;
        int pressLeft = 0;
        while (left < name.length() && pressLeft < typed.length()) {
            if (typed.charAt(pressLeft) == name.charAt(left)) {
                pressLeft++;
                left++;
            } else if (pressLeft > 0 && typed.charAt(pressLeft) == typed.charAt(pressLeft - 1)) {
                pressLeft++;
            } else {
                return false;
            }
        }
        for (int i = pressLeft; i < typed.length(); i++) {
            if (i > 0 && typed.charAt(i) != typed.charAt(i - 1)) {
                return false;
            }
        }
        return left == name.length();
    }

    public static void main(String[] args) {
        String name = "alex";
        String typed = "alexxr";
        isLongPressedName isLongPressedName = new isLongPressedName();
        isLongPressedName.isLongPressedName(name, typed);
    }
}
