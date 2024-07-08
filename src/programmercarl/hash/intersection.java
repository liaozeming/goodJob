package programmercarl.hash;

import java.util.*;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], Boolean.TRUE);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) == Boolean.TRUE) {
                set.add(nums2[i]);
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
