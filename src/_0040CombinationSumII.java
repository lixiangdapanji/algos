import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        return dfs(a, a.length - 1, target);
    }
    private List<List<Integer>> dfs(int[] a, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        if (index == -1 || target < 0) {
            return result;
        }

        result = dfs(a, index - 1, target - a[index]);
        for (List<Integer> list : result) {
            list.add(a[index]);
        }

        while (index > 0 && a[index - 1] == a[index]) {
            index--;
        }

        result.addAll(dfs(a, index - 1, target));
        return result;
    }
}
