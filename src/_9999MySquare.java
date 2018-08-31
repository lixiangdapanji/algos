public class _9999MySquare {
    private int n;
    private int m;
    private int[][] matrixSum;
    public _9999MySquare (int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length ;
        matrixSum = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            matrixSum[i][0] = 0;
        }

        for (int j = 0; j < m + 1; j++) {
            matrixSum[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                matrixSum[i][j] = matrixSum[i - 1][j] + matrixSum[i][j - 1] - matrixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int countOnes (int x1, int y1, int x2, int y2) {
        return matrixSum[x2 + 1][y2 + 1] + matrixSum[x1][y1] - matrixSum[x1][y2 + 1] - matrixSum[x2 + 1][y1];
    }
}
