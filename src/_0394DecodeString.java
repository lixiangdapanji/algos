import java.util.Stack;

public class _0394DecodeString {
    public String decodeString(String s) {
        Stack<Node> stack = new Stack<>();
        Node dummy = new Node(0, new StringBuilder());
        stack.push(dummy);

        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                continue;
            }

            if (c == '[') {
                int freq = Integer.parseInt(s.substring(start, i));
                StringBuilder sb = new StringBuilder();
                Node node = new Node(freq, sb);
                stack.push(node);
            } else if (c == ']') {
                Node node = stack.pop();
                int freq = node._freq;
                StringBuilder newSb = new StringBuilder();
                for (int j = 0; j < freq; j++) {
                    newSb.append(node._sb);
                }
                stack.peek()._sb.append(newSb);
            } else {
                stack.peek()._sb.append(c);
            }

            start = i + 1;
        }

        return dummy._sb.toString();
    }

    private class Node {
        int _freq;
        StringBuilder _sb;
        public Node(int freq, StringBuilder sb) {
            _freq = freq;
            _sb = sb;
        }
    }
}
