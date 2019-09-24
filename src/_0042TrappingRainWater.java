public class _0042TrappingRainWater {
    //    public int trap(int[] h) {
//        final int n = h.length;
//        if (n == 0) {
//            return 0;
//        }
//
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//
//        int max = h[0];
//
//        leftMax[0] = 0;
//        for (int i = 1; i < n; i++) {
//            // leftMax[i] = Math.max(leftMax[i -1], h[i]);
//            if (h[i] == -1) {
//                leftMax[i] = 0;
//                max = h[i];
//            } else if (max <= h[i]) {
//                max = h[i];
//                leftMax[i] = 0;
//            } else {
//                leftMax[i] = max;
//            }
//        }
//        //leftMax = [0, 0, 1, 0, 2, 2, 0, 3, 3, 3, 0, 2]
//        //rightMax= [0, 0, 2, 0, 0, 3, 3, 0, 0, 2, 2, 1]
//        //      h = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
//        rightMax[n - 1] = 0;
//        max = h[n -1];
//        for (int i = n - 2; i >= 0; i--) {
//            if (h[i] == -1) {
//                rightMax[i] = 0;
//                max = h[i];
//            }
//            else if (max <= h[i]) {
//                max = h[i];
//                rightMax[i] = 0;
//            } else {
//                rightMax[i] = max;
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            int tmp = Math.min(leftMax[i], rightMax[i]) - h[i];
//            tmp = tmp > 0 ? tmp : 0;
//            sum += tmp;
//        }
//        return sum;
//    }
//    public int trap(int[] h) {
//        final int n = h.length;
//        if (n == 0) {
//            return 0;
//        }
//
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//
//        leftMax[0] = h[0];
//        for (int i = 1; i < n; i++) {
//            leftMax[i] = Math.max(leftMax[i - 1], h[i]);
//        }
//
//        rightMax[n - 1] = h[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(rightMax[i + 1], h[i]);
//        }
//
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += Math.min(leftMax[i], rightMax[i]) - h[i];
//        }
//        return sum;
//    }

    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        for (int i = 1; i < n - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for(int j = i; j >= 0; j--)	{
                //Search the left part for max bar size
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int j = i; j < n; j++) {
                //Search the right part for max bar size
                maxRight = Math.max(maxRight, height[j]);
            }
            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }
}
