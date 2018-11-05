public class _0673NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cont = new int[n];
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(length(nums, i, len), max);
        }
        System.out.print(max);
        for (int i = 0; i < n; i++) {
            if (length(nums, i, len) == max) {
                cnt += count(nums, i, cont);
            }
        }
        return cnt;
    }

    private int count (int[] nums, int j, int[] cont) {
        if (j == 0) {
            return 1;
        }
        if (cont[j] > 0) {
            return cont[j];
        }
        int res = 0;
        int l = length(nums, j, cont);
        for (int i = 0; i < j; i++) {
            if (nums[j] > nums[i] && length(nums, j, cont) == l - 1) {
                res += count(nums, i, cont);
            }
        }

        if (res == 0) {
            res = 1;
        }

        cont[j] = res;
        return cont[j];
    }

    private int length(int[] nums, int j, int[] len) {
        if (j == 0) {
            return 1;
        }
        if (len[j] > 0) {
            return len[j];
        }
        int res = 1;
        for (int i = 0; i < j; i++) {
            if (nums[j] > nums[i]) {
                res = Math.max(res, length(nums, i, len) + 1);
            }
        }
        len[j] = res;
        return len[j];
    }
}
