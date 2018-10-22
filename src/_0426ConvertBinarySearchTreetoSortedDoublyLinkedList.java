import java.util.Stack;

public class _0426ConvertBinarySearchTreetoSortedDoublyLinkedList {
    public Node426 treeToDoublyList(Node426 root) {
        if (root == null) return root;
        Node426 pre = null;
        Node426 head = null;
        Node426 cur = root;
        Stack<Node426> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null) {
                // connect pre and cur to a doublyList
                pre.right = cur;
                cur.left = pre;
            } else {
                head = cur;
            }
            pre = cur;
            cur = cur.right;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }
}

class Node426 {
    public int val;
    public Node426 left;
    public Node426 right;

    public Node426() {}

    public Node426(int _val, Node426 _left, Node426 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
