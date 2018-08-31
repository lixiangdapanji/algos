import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        TreeNode root = bfsBuildTree(n);
        return bfsWalkTree(root);
    }

    private TreeNode bfsBuildTree(int n) {
        TreeNode root = new TreeNode('(');
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(new MyNode(root, 1, 0));

        while (!queue.isEmpty()) {
            MyNode myNode = queue.remove();

            if (myNode._leftUsed < n) {
                //生左孩子 并且和我连起来
                myNode._node._left = new TreeNode('(');
                queue.add(new MyNode(myNode._node._left, myNode._leftUsed + 1, myNode._rightUsed));
            }

            if (myNode._leftUsed > myNode._rightUsed) {
                //生右孩子 并且和我连接起来
                myNode._node._right = new TreeNode(')');
                queue.add(new MyNode(myNode._node._right, myNode._leftUsed, myNode._rightUsed + 1));
            }
        }
        return root;
    }


    private List<String> bfsWalkTree(TreeNode root) {
        List<String> result = new ArrayList<>();

        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<StringBuilder> pathQueue = new LinkedList<>();

        treeQueue.add(root);
        pathQueue.add(new StringBuilder());

        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.remove();
            StringBuilder path = pathQueue.remove();

            //1op at node
            path.append(node._par);
            if (node._left == null && node._right == null) {
                result.add(path.toString());
            }

            //2go down to children
            if (node._left != null) {
                treeQueue.add(node._left);
                pathQueue.add(new StringBuilder(path));
            }

            if (node._right != null) {
                treeQueue.add(node._right);
                pathQueue.add(new StringBuilder(path));
            }
        }
        return result;
    }

    private class TreeNode {
        char _par;
        TreeNode _left;
        TreeNode _right;
        public TreeNode(char par) {
            _par = par;
        }
    }

    private class MyNode {
        TreeNode _node;
        int _leftUsed;
        int _rightUsed;
        public MyNode(TreeNode node, int leftUsed, int rightUsed) {
            _node = node;
            _leftUsed = leftUsed;
            _rightUsed = rightUsed;
        }
    }
}
