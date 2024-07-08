package programmercarl.other;

import java.util.ArrayList;
import java.util.List;

public class ladderLength {
    int min = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> isVisited = new ArrayList<>();
        isVisited.add(beginWord);
        dfs(beginWord, endWord, wordList, isVisited);
        return min==Integer.MAX_VALUE ? 0 : min;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, List<String> isVisited) {
        if (beginWord.equals(endWord)) {
            min = Math.min(min, isVisited.size());
            return;
        }
        // 相差一位的字符串
        List<String> ladders = getLadder(beginWord, wordList);
        for (int i = 0; i < ladders.size(); i++) {
            if (isVisited.contains(ladders.get(i))) {
                continue;
            }
            isVisited.add(ladders.get(i));
            dfs(ladders.get(i), endWord, wordList, isVisited);
            isVisited.remove(isVisited.size() - 1);
        }
    }

    private List<String> getLadder(String beginWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (check(wordList.get(i), beginWord)) {
                res.add(wordList.get(i));
            }
        }
        return res;
    }

    private boolean check(String s, String beginWord) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != beginWord.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

}
