import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {
    class Node {
        public int row, col, val;
        Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public class Solution {
        public int[] mergekSortedArrays(int[][] arrays) {
            if (arrays == null) {
                return new int[0];
            }
            //time O(nlogk)
            //space O(logk)
            int total_size = 0;
            PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i].length > 0) {
                    Node node = new Node(i, 0, arrays[i][0]);
                    minHeap.add(node);
                    //get the total size of the array
                    total_size += arrays[i].length;
                }
            }

            int[] result = new int[total_size];
            int index = 0;
            while (!minHeap.isEmpty()) {
                Node node = minHeap.poll();
                result[index++] = node.val;
                if (node.col + 1 < arrays[node.row].length) {
                    node.col += 1;
                    node.val = arrays[node.row][node.col];
                    minHeap.add(node);
                }
            }
            return result;
        }
    }
}
