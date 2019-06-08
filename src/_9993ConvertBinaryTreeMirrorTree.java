import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _9993ConvertBinaryTreeMirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        return root;
    }

    private class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;
        public TreeNode (int val) {
            this.val = val;
        }
    }

    public TreeNode mirrorTreeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
