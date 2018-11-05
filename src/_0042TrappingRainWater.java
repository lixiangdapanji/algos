public class _0042TrappingRainWater {
    public int trap(int[] h) {
        final int n = h.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int max = h[0];

        leftMax[0] = 0;
        for (int i = 1; i < n; i++) {
            // leftMax[i] = Math.max(leftMax[i -1], h[i]);
            if (h[i] == -1) {
                leftMax[i] = 0;
                max = h[i];
            } else if (max <= h[i]) {
                max = h[i];
                leftMax[i] = 0;
            } else {
                leftMax[i] = max;
            }
        }
        //leftMax = [0, 0, 1, 0, 2, 2, 0, 3, 3, 3, 0, 2]
        //rightMax= [0, 0, 2, 0, 0, 3, 3, 0, 0, 2, 2, 1]
        //      h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        rightMax[n - 1] = 0;
        max = h[n -1];
        for (int i = n - 2; i >= 0; i--) {
            if (h[i] == -1) {
                rightMax[i] = 0;
                max = h[i];
            }
            else if (max <= h[i]) {
                max = h[i];
                rightMax[i] = 0;
            } else {
                rightMax[i] = max;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Math.min(leftMax[i], rightMax[i]) - h[i];
            tmp = tmp > 0 ? tmp : 0;
            sum += tmp;
        }
        return sum;
    }
}
