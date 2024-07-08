package practice.美团.美团2024届秋招笔试第一场编程真题;

import java.util.*;

public class second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String s = in.next();
        String t = in.next();
        List<Integer> samePosition = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                samePosition.add(i);
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!samePosition.contains(i)) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        int temp = 0;
        for (int i = 0; i < t.length(); i++) {
            if (!samePosition.contains(i)) {
                if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0) {
                    temp++;
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            }
        }
        int sum = (Math.min(temp, 2)) + samePosition.size();
        System.out.println(sum);
    }
}
