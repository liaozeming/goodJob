package programmercarl.backTrack;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    String[] digitString = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        int length = digits.length();
        String temp = "";
        backTrack(0, length, digits, temp);
        return res;
    }

    private void backTrack(int index, int length, String digits, String temp) {
        if (index == length) {
            res.add(new String(temp));
            return;
        }
        int c = digits.charAt(index) - 48;
        String numberDigits = digitString[c - 2];
        for (int i = 0; i < numberDigits.length(); i++) {
            temp = temp + numberDigits.charAt(i);
            backTrack(index + 1, length, digits, temp);
            temp = temp.subSequence(0, temp.length() - 1).toString();
        }
    }

    public static void main(String[] args) {
        letterCombinations letterCombinations = new letterCombinations();
        letterCombinations.letterCombinations("2");
    }
}
