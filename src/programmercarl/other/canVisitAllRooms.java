package programmercarl.other;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class canVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        bfs(rooms, isVisited);
        for (boolean b : isVisited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void bfs(List<List<Integer>> rooms, boolean[] isVisited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (isVisited[poll]) {
                continue;
            }
            isVisited[poll] = true;
            for (int i = 0; i < rooms.get(poll).size(); i++) {
                queue.add(rooms.get(poll).get(i));
            }
        }
    }


}
