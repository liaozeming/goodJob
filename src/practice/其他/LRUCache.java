package practice.其他;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int size = 0;
    int capacity = 0;
    LruNode head = new LruNode(-1, -1);
    LruNode tail = new LruNode(-1, -1);


    Map<Integer, LruNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LruNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    private void removeNode(LruNode node) {
        size--;
        LruNode pre = node.pre;
        LruNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void addToHead(LruNode node) {
        size++;
        LruNode next = head.next;
        node.pre = head;
        node.next = next;
        next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        LruNode node = map.get(key);
        if (node == null) {
            node = new LruNode(key, value);
            map.put(key, node);
            addToHead(node);
            if (size > capacity) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
        } else {
            if (value != node.val) {
                node.val = value;
            }
            removeNode(node);
            addToHead(node);
        }
    }

    public static class LruNode {
        int key;
        int val;
        LruNode pre;
        LruNode next;

        public LruNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
    }
}
