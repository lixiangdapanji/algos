import java.util.ArrayList;
import java.util.List;

public class _0301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        //get the invalid parentheses nums
        int numL = 0;
        int numR = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                numL++;
            } else if (c == ')') {
                if (numL > 0) {
                    numL--;
                } else {
                    numR++;
                }
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, numL, numR, 0, res);
        return res;
    }
    private void dfs(String s, int numL, int numR, int start, List<String> res) {
        //base case
        if (numL == 0 && numR == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        //general case
        for (int i = start; i < s.length(); i++) {
            //砍枝
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            char c  = s.charAt(i);
            if (c == '(' || c == ')') {
                String cur = s.substring(0, i) + s.substring(i);
                if (numR > 0 && c == ')') {
                    dfs(cur, numL, numR - 1, i, res);
                } else if (numL > 0 && c == '(') {
                    dfs(cur, numL - 1, numR, i, res);
                }
            }
        }
    }
    private boolean isValid (String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
