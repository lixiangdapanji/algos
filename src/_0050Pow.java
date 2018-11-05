public class _0050Pow {
    public double myPow(double x, int n) {
        return myOwnPow(x, n);
    }

    private double myOwnPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1 / myOwnPow(x, 0 - n);
        }
        if (n == 1) {
            return x;

        }
        double halfResult = myOwnPow(x, n / 2);
        double result = halfResult * halfResult;
        if ((n & 1) == 1) {
            result *= x;
        }
        return result;
    }
}
