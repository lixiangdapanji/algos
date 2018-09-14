public class _0547FriendCircles {
    public int findCircleNum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int n = grid.length;

        boolean[] visited = new boolean[n];
        int number = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(grid, i, visited);
                number++;
            }
        }
        return number;
    }

    private void dfs(int[][] grid, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                dfs(grid, j, visited);
            }
        }
    }
}
