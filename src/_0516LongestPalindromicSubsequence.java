public class _0516LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] memo = new int[n][n];

        return dfs(s, 0, s.length() - 1, memo);
    }

    private int dfs(String s, int from, int to, int[][] memo) {
        if (from > to) return 0;
        if (from == to) return 1;
        if (memo[from][to] > 0) {
            return memo[from][to];
        }

        int maxLength = 1;
        if (s.charAt(from) == s.charAt(to)) {
            maxLength = 2 + dfs(s, from + 1, to - 1, memo);
        } else {
            maxLength = Math.max(maxLength, dfs(s, from + 1, to, memo));
            maxLength = Math.max(maxLength, dfs(s, from, to - 1, memo));
        }
        return memo[from][to] = maxLength;
    }
}
