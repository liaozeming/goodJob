package programmercarl.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    Queue<Integer> pushQueue;
    Queue<Integer> popQueue;

    public MyStack() {
        pushQueue = new ArrayDeque<>();
        popQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        if (pushQueue.isEmpty()) {
            popQueue.add(x);
        } else {
            pushQueue.add(x);
        }
    }

    public int pop() {
        if (pushQueue.isEmpty()) {
            while (popQueue.size() > 1) {
                pushQueue.add(popQueue.poll());
            }
            return !popQueue.isEmpty() ? popQueue.poll() : -1;
        }
        if (popQueue.isEmpty()) {
            while (pushQueue.size() > 1) {
                popQueue.add(pushQueue.poll());
            }
            return !pushQueue.isEmpty() ? pushQueue.poll() : -1;
        }
        return -1;
    }

    public int top() {
        if (pushQueue.isEmpty()) {
            while (popQueue.size() > 1) {
                pushQueue.add(popQueue.poll());
            }
            int poll = popQueue.isEmpty() ? -1 : popQueue.poll();
            pushQueue.add(poll);
            return poll;
        }
        if (popQueue.isEmpty()) {
            while (pushQueue.size() > 1) {
                popQueue.add(pushQueue.poll());
            }
            int poll = pushQueue.isEmpty() ? -1 : pushQueue.poll();
            popQueue.add(poll);
            return poll;
        }
        return -1;
    }

    public boolean empty() {
        return popQueue.isEmpty() && pushQueue.isEmpty();
    }
}
