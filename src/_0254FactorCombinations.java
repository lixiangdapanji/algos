import java.util.ArrayList;
import java.util.List;

public class _0254FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> leftPath = new ArrayList<>();
        dfs(1, n, result, leftPath);
        return result;
    }
    private void dfs(int left, int right, List<List<Integer>> result, List<Integer> leftPath) {
        // entering the node
        if (left != 1) {
            leftPath.add(left);
        }
        // op at node
        if (left != 1) {
            List<Integer> list = new ArrayList<>(leftPath);
            list.add(right);
            result.add(list);
        }

        //2 children
        for (int leftChild = Math.max(2, left); leftChild <= (int)Math.sqrt(right); leftChild++) {
            int rightChild = right / leftChild;
            if (leftChild * rightChild == right) {
                dfs(leftChild, rightChild, result, leftPath);
            }
        }
        // leaving the node
        if (left != 1) {
            leftPath.remove(leftPath.size() - 1);
        }
    }
}
