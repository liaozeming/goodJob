package programmercarl.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class commonChars {
    public List<String> commonChars(String[] words) {
        int[] res = new int[26];
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    res[c - 'a']++;
                }
            }
        }
        List<String> commonString = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 3) {
                char c = (char) ('a' + i);
                commonString.add(String.valueOf(c));
            }
        }
        return commonString;
    }
}
