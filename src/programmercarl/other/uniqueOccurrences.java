package programmercarl.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        uniqueOccurrences uniqueOccurrences = new uniqueOccurrences();
        boolean b = uniqueOccurrences.uniqueOccurrences(arr);
        System.out.println(b);
    }
}
