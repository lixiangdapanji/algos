public class _0084LargestRectangleinHistogram {
    public int largestRectangleArea(int[] h) {
        final int n = h.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];

        for (int i = 0; i < n; i++) {
            leftMost[i] = i;
            while (leftMost[i] > 0 && h[leftMost[i] - 1] >= h[i]) {
                leftMost[i] = leftMost[leftMost[i] - 1];
            }
        }

        for (int i = n -1; i >= 0; i--) {
            rightMost[i] = i;
            while (rightMost[i] + 1 < n && h[rightMost[i] + 1] >= h[i]) {
                rightMost[i] = rightMost[rightMost[i] + 1];
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, h[i] *(rightMost[i] - leftMost[i] + 1));
        }
        return result;
    }
}
