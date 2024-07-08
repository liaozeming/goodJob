package programmercarl.greedy;

import java.util.*;
import java.util.stream.IntStream;

public class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] == res.size()) {
                res.add(people[i]);
            } else {
                res.add(people[i][1], people[i]);
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
//        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        reconstructQueue reconstructQueue =new reconstructQueue();
//        int[][] res = reconstructQueue.reconstructQueue(people);
        List<Integer> res = new ArrayList<>();
        IntStream intStream = res.stream().mapToInt(Integer::intValue);
        res.toArray(new String[0]);
    }
}
