import java.util.Comparator;
import java.util.PriorityQueue;

public class _0378KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pos> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> matrix[o._row][o._col]));
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new Pos(i, 0));
        }
        while(k != 1) {
            k--;
            Pos pos = minHeap.poll();
            if (pos._col < matrix[0].length - 1) {
                minHeap.add(new Pos(pos._row, pos._col + 1));
            }
        }
        Pos index = minHeap.peek();
        return matrix[index._row][index._col];
    }

    private class Pos{
        int _row;
        int _col;
        public Pos(int row, int col) {
            _row = row;
            _col = col;
        }
    }
}
