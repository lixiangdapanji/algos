public class Radix {
    static int baseToBase(String num, int base1, int base2) {
        int source = convFrmBaseToDeci(num, base1);
        return convFrmDecToBase(source, base2);
    }



    static int convFrmDecToBase(int num, int base) {

        StringBuilder sb = new StringBuilder();
        int rem;
        while (num != 0) {
            rem = num % base;
            if (base == 16) {
                if (rem == 10)
                    sb.append('A');
                else if (rem == 11)
                    sb.append('B');
                else if (rem == 12)
                    sb.append('C');
                else if (rem == 13)
                    sb.append('D');
                else if (rem == 14)
                    sb.append('E');
                else if (rem == 15)
                    sb.append('F');
                else
                    sb.append(rem);
            } else {
                sb.append(rem);
            }
            num /= base;
        }
        // Reverse the result
        String result = new StringBuffer(sb.toString()).reverse().toString();
        return Integer.valueOf(result);
    }

    static int convFrmBaseToDeci(String num, int base) {

        if (base < 2 || (base > 10 && base != 16))
            return -1;

        int val = 0;
        int power = 1;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = digitToVal(num.charAt(i));

            if (digit < 0 || digit >= base)
                return -1;

            // Decimal equivalent is str[len-1]*1 +
            // str[len-1]*base + str[len-1]*(base^2) + ...
            val += digit * power;
            power = power * base;
        }

        return val;
    }

    static int digitToVal(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }
}

