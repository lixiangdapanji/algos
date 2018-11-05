import java.util.Stack;

public class _0071SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int start = 1;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                processStack(stack, path, start, i);
                start = i + 1;
            }
        }
        if (path.charAt(path.length() - 1) != '/') {
            processStack(stack, path, start, path.length());
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s);
        }

        return ("/" + sb);
    }
    private void processStack(Stack<String> stack, String path, int start, int end) {
        if (path.substring(start, end).equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else if (start < end && !path.substring(start, end).equals(".")) {
            stack.push(path.substring(start, end));
        }
    }
}
