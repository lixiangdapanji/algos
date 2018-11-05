import java.util.NoSuchElementException;
import java.util.Stack;

public class _9994BinaryTreePostOrderIterator {
    Stack<_9994TreeNode> stack = new Stack<>();

    /** find the first leaf in a tree rooted at cur and store intermediate nodes */
    private void findNextLeaf(_9994TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    /** Constructor */
    public _9994BinaryTreePostOrderIterator(_9994TreeNode root) {
        findNextLeaf(root);
    }

    /** {@inheritDoc} */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** {@inheritDoc} */
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("All nodes have been visited!");
        }

        _9994TreeNode res = stack.pop();
        if (!stack.isEmpty()) {
            _9994TreeNode top = stack.peek();
            if (res == top.left) {
                findNextLeaf(top.right); // find next leaf in right sub-tree
            }
        }

        return res.val;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported.");
    }

    class _9994TreeNode {
        _9994TreeNode left;
        _9994TreeNode right;
        int val;
        public _9994TreeNode(int val) {
            this.val = val;
        }
    }
}



