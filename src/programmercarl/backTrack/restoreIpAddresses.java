package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    List<List<Integer>> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(0, s, temp);
        List<String> addresses = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            StringBuilder addressBuilder = new StringBuilder();
            for (int j = 0; j < list.size() - 1; j++) {
                addressBuilder.append(list.get(j));
                addressBuilder.append(".");
            }
            addressBuilder.append(list.get(list.size() - 1));
            addresses.add(new String(addressBuilder));
        }
        return addresses;
    }

    private void backTrack(int index, String s, List<Integer> temp) {
        if (temp.size() == 4 && index != s.length()) {
            return;
        }
        if (index == s.length() && temp.size() == 4) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // 前导0
            if (s.charAt(index) == '0' && i > index) {
                continue;
            }
            String substring = s.substring(index, i + 1);
            int ip = Integer.parseInt(substring);
            if (ip > 255) {
                break;
            }
            temp.add(ip);
            backTrack(i + 1, s, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        restoreIpAddresses restoreIpAddresses = new restoreIpAddresses();
        String s = "25525511135";
        List<String> list = restoreIpAddresses.restoreIpAddresses(s);
        list.forEach(System.out::println);
    }
}
