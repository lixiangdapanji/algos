import java.util.List;
import java.util.Stack;

public class _0636ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(-1, 0));

        for (String log : logs) {
            String[] logArr = log.split(":");
            int id = Integer.parseInt(logArr[0]);
            int time = Integer.parseInt(logArr[2]);
            if (logArr[1].equals("start")) {
                stack.push(new Node(id, time));
            } else {
                Node cur = stack.pop();
                int consumed = time - cur._start + 1 - cur._consumedByChildren;
                result[id] += consumed;
                stack.peek()._consumedByChildren += time - cur._start + 1;
            }
        }
        return result;
    }
    private class Node {
        final int _id;
        final int _start;
        int _consumedByChildren;

        public Node(int id, int start) {
            _id = id;
            _start = start;
            _consumedByChildren = 0;
        }
    }
}
