import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class _0297SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            // op at node
            if (node == null) {
                result.append("null,");
            } else {
                result.append(node.val + ",");
            }
            // go down to children
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        //result.deleteCharAt(result.length() - 1);
        while(result.length() >= 5 && result.substring(result.length() - 5, result.length()).equals("null,")) {
            result.delete(result.length() - 5, result.length());
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] vals = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    index++;
                    if (!vals[index].equals("null")) {
                        node.left = new TreeNode(Integer.valueOf(vals[index]));
                    }
                    queue.add(node.left);

                    index++;
                    if (!vals[index].equals("null")) {
                        node.right = new TreeNode(Integer.valueOf(vals[index]));
                    }
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
