import java.util.Deque;
import java.util.LinkedList;

public class _0239SlidingWindowMax {
    public  int[] maxSildingWindow(int[] a, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("not valid");
            //return new int[]{};
        }
        int[] result = new int[a.length - k + 1];
        Deque<Integer> indices = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            while(!indices.isEmpty() && a[indices.getLast()] < a[i]) {
                indices.removeLast();
            }

            indices.addLast(i);

            if (!indices.isEmpty() && indices.getFirst() == i - k) {
                indices.removeFirst();
            }

            if (i >= k - 1) {
                result[i - k + 1] = a[indices.getFirst()];
            }
        }
        return result;
    }

}
