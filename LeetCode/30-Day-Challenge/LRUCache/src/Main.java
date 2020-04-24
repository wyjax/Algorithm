import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

class LRUCache2 {
    HashMap<Integer, Integer> cache = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    final int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            list.remove(new Integer(key));
            list.add(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key) && list.size() == capacity) { // O(1)
            cache.remove(list.get(0)); // o(1)
            list.remove(0); // o(1)
        }
        cache.put(key, value);
        list.remove(new Integer(key));
        list.add(key);
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new LinkedHashMap<>();
    Node head;
    Node tail;
    final int size;

    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            nodeUpdate(cur);

            return map.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            nodeUpdate(node);
            node.val = value;
        }
        else {
            if (map.size() == size) {
                Node node = tail;
                tail = node.prev;

                if (tail != null) {
                    tail.next = null;
                }
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (tail == null) {
                tail = head;
            }
            map.put(key, node);
        }
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void nodeUpdate(Node node) {
        if (node == head) {
            return;
        }
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        if (node == tail && prev != null) {
            tail = prev;
        }

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
