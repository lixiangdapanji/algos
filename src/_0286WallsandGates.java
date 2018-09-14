import java.util.LinkedList;
import java.util.Queue;

public class _0286WallsandGates {
    final static int WALL = -1;
    final static int GATE = 0;
    final static int CELL = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int[][] steps = new int[rooms.length][rooms[0].length];
        bfs(rooms, steps);
        copy(rooms, steps);
    }

    private void copy(int[][] rooms, int[][] steps) {
        final int n = rooms.length;
        final int m = rooms[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == CELL) {
                    if (steps[i][j] != 0) {
                        rooms[i][j] = steps[i][j];
                    } else {
                        rooms[i][j] = CELL;
                    }
                }
            }
        }
    }

    private void bfs(int[][] rooms, int[][] steps) {
        final int n = rooms.length;
        final int m = rooms[0].length;

        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == GATE) {
                    rowQueue.add(i);
                    colQueue.add(j);
                }
            }
        }

        int level = 0;
        while (!rowQueue.isEmpty()) {
            final int size = rowQueue.size();

            for (int i = 0; i < size; i++) {
                int row = rowQueue.remove();
                int col = colQueue.remove();

                if (steps[row][col] != 0) {
                    continue;
                }
                steps[row][col] = level;

                if (row - 1 >= 0 && rooms[row - 1][col] == CELL) {
                    rowQueue.add(row - 1);
                    colQueue.add(col);
                }
                if (row + 1 < n && rooms[row + 1][col] == CELL) {
                    rowQueue.add(row + 1);
                    colQueue.add(col);
                }
                if (col - 1 >= 0 && rooms[row][col - 1] == CELL) {
                    rowQueue.add(row);
                    colQueue.add(col - 1);
                }
                if (col + 1 < m && rooms[row][col + 1] == CELL) {
                    rowQueue.add(row);
                    colQueue.add(col + 1);
                }
            }
            level++;
        }
    }
}
