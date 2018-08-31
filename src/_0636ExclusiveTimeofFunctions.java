import java.util.List;
import java.util.Stack;

public class _0636ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int prev = Integer.parseInt(s[2]);
        int i = 1;
        while ( i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            }
            if (s[1].equals("end")) {
                result[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return result;
    }
}
