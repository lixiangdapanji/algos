public class Triangle {
    public void drawTriangle(int n) {
        for (int i = 0; i < n; i++) {
            //calculate the leading space
            int t = (2 * n + 1 - (2 * i -1)) / 2;
            for (int j = 0; j < t; j++) {
                System.out.print(" ");
            }
            // base case
            if (i == 0) {
                System.out.println("*");
                continue;
            }
            if (i == n - 1) {
                for (int s = 0; s < 2 * n - 1; s++) {
                    System.out.print("*");
                }
                break;
            }

            //general case
            System.out.print("*");
            //calculate the spaces between two "*"
            for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print(" ");
            }
            //add the "*" to the end
            System.out.print("*");
            //Go to the next line
            System.out.println();
        }

    }
}