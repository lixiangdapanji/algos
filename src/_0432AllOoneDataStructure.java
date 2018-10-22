import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _0432AllOoneDataStructure {
    MyList list;
    // for accessing a specific Bucket among the Bucket list in O(1) time
    private Map<Integer, Node> valueToNode;
    // keep track of count of keys
    private Map<String, Integer> keyToValue;

    public _0432AllOoneDataStructure() {
        list = new MyList();
        valueToNode = new HashMap<>();
        keyToValue = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyToValue.containsKey(key)) {
            changeKey(key, 1);
        } else { // if the key's value == 0
            keyToValue.put(key, 1);
            Node node = list.getDummyNext();
            if (node.value != 1) {// update the list
                list.addNodeAfter(new Node(1), node);
            }
            list.getDummyNext().keySet.add(key);
            valueToNode.put(1, node);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyToValue.containsKey(key)) {
            int count = keyToValue.get(key);
            if (count == 1) {
                keyToValue.remove(key);
                Node node = valueToNode.get(count);
                removeKey(node, key);
            } else {
                changeKey(key, -1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return list.getLastNode();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return list.getFirstNode();
    }

    // helper function to make change on given key according to offset
    private void changeKey(String key, int offset) {
        int count = keyToValue.get(key);
        keyToValue.put(key, count + offset);
        Node curNode = valueToNode.get(count);
        Node newNode;
        if (valueToNode.containsKey(count + offset)) {
            // target list already exists
            newNode = valueToNode.get(count + offset);
        } else {
            // add new listNode
            newNode = new Node(count + offset);
            valueToNode.put(count + offset, newNode);
            list.addNodeAfter(newNode, offset == 1 ? curNode : curNode.prev);
        }

        newNode.keySet.add(key);
        removeKey(curNode, key);
    }

    private void removeKey(Node node, String key) {
        node.keySet.remove(key);
        //if keySet.size == 0 there is no more element left, so the node will be deleted in list and in valueToNode map
        //because this freq does not exists any more
        if (node.keySet.size() == 0) {
            list.removeNode(node);
            valueToNode.remove(node.value);
        }
    }

}

class Node {
    int value;
    Set<String> keySet;
    Node next;
    Node prev;
    public Node(int value) {
        this.value = value;
        keySet = new HashSet<>();
    }
}

class MyList {
    // maintain a doubly linked list of node
    private Node dummyHead;
    private Node dummyTail;
    public MyList() {
        dummyHead = new Node(Integer.MIN_VALUE);
        dummyTail = new Node(Integer.MAX_VALUE);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

     void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    // add dummyHead after preBucket
     void addNodeAfter(Node node, Node dummyTail) {
        node.prev = dummyTail;
        node.next = dummyTail.next;
        dummyTail.next.prev = node;
        dummyTail.next = node;
    }

    Node getDummyNext() {
        return dummyHead.next;
    }

    String getLastNode() {
        if (dummyHead.next == dummyTail) {
            return "";
        } else {
            return dummyTail.prev.keySet.iterator().next();
        }
    }

    String getFirstNode() {
        if (dummyHead.next == dummyTail) {
            return "";
        } else {
            return dummyHead.next.keySet.iterator().next();
        }
    }
}