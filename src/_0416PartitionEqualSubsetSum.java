import java.util.Arrays;

public class _0416PartitionEqualSubsetSum {
    public boolean canPartition(int[] a) {
        Arrays.sort(a);
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if ( sum % 2 == 1) {
            return false;
        }

        return dfs(a, a.length - 1, sum / 2);
    }
    private boolean dfs(int[] a, int index, int target) {
        boolean result = false;

        if (target == 0) {
            return true;
        }
        if (index == -1 || target < 0) {
            return false;
        }

         int j = index - 1;
        while (j != -1 && a[j] == a[index]) {
            j--;
        }

        result = dfs(a, index -1, target - a[index]) || dfs(a, index - 1, target);

        return result;
    }
}
