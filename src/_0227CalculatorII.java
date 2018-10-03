import java.util.Stack;

public class _0227CalculatorII {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack();
        int num = 0;
        int res = 0;
        int sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                num = calculate(s.substring(i + 1));
            }

            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                    num = 0;
                } else if (sign == '-') {
                    stack.push(-num);
                    num = 0;
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                    num = 0;
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                    num = 0;
                }
                sign = c;
                if (c == ')') {
                    break;
                }
            }

        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }



}