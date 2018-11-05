public class _0029DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor cannot be 0");
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
                // } else if (divisor == 1) {
                //     return Integer.MIN_VALUE;
            }
        }
        long divd =(long) dividend;
        long divs =(long) divisor;
        int sign = 1;

        //change it to positive number to deal with
        if (divd < 0) {
            divd = -divd;
            sign = -sign;
        }
        if (divs < 0) {
            divs = -divs;
            sign = -sign;
        }
        int res = 0;
        while (divd >= divs) {
            int shift = 0;
            //先左移再吧比较
            // 19 / 6
            //
            while (divd >= divs << shift) {
                //divs = divs << shift;
                shift++;
                //System.out.println(shift);
                //32/5  -> shift = 3 / 2
                //20 + 12
                // 4 + 2
            }
            //先+= 再左移 if I do not have the ()
            res += (1 << (shift - 1));
            divd -= (divs << (shift - 1));
        }
        return res * sign;
    }
}


