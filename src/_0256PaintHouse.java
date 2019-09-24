public class _0256PaintHouse {
    public class Solution {
        public int minCost(int[][] costs) {
            if (costs.length == 0) return 0;
            int lastR = costs[0][0];
            int lastG = costs[0][1];
            int lastB = costs[0][2];
            for (int i = 1; i < costs.length; i++) {
                int curR = Math.min(lastG, lastB) + costs[i][0];
                int curG = Math.min(lastR, lastB) + costs[i][1];
                int curB = Math.min(lastR, lastG) + costs[i][2];
                lastR = curR;
                lastG = curG;
                lastB = curB;
            }
            return Math.min(Math.min(lastR, lastG), lastB);
        }
    }
}

//    The basic idea is when we have painted the first i houses, and want to paint the i+1 th house, we have 3 choices:
//    paint it either red, or green, or blue. If we choose to paint it red, we have the follow deduction:
//
//        paintCurrentRed = min(paintPreviousGreen,paintPreviousBlue) + costs[i+1][0]
//        Same for the green and blue situation. And the initialization is set to costs[0], so we get the code: