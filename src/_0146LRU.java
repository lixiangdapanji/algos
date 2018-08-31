import java.util.*;


public class _0146LRU {
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    int capacity;

    /*
     * @param capacity: An integer
     */public _0146LRU(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        // if key doesn't exist
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);

        //if node is already tail
        if (node == tail) {
            return node.value;
        }

        //take node out of its original position
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //put node to the tail
        node.next = null;
        node.prev = tail;
        tail.next = node;
        tail = node;

        map.put(key, node);

        return node.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here

        // if key already exist in the cache, "get" method would put it into the tail position
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        // if key is new
        ListNode node = new ListNode(key, value);

        // entry point: if tail is not set yet, replace tail with node
        if (tail.value == 0) {
            node.prev = head;
            head.next = node;
            tail = node;
            map.put(key, node);
            return;
        }

        // add node to the tail
        node.prev = tail;
        tail.next = node;
        tail = node;
        map.put(key, node);

        //if cache is bigger than capacity
        if (map.size() > capacity) {
            ListNode lru = head.next;
            head.next.next.prev = head;
            head.next = head.next.next;
            map.remove(lru.key);
        }
    }
}

class ListNode {
    public int key;
    public int value;
    public ListNode prev;
    public ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
