public class _0439TernaryExpressionParser {
    public String parseTernary(String expression) {
        return dfs(expression, 0)._val;
    }

    private Result dfs(String s, int startIndex) {
        char c = s.charAt(startIndex);
        if ('0' <= c && c <='9') {
         return new Result(c + "", startIndex);
         }

        //c ？ 'T' : 'F'
        if (startIndex + 1 < s.length() && s.charAt(startIndex + 1) == '?') {
            Result leftResult = dfs(s, startIndex + 2);
            Result rightResult = dfs(s, leftResult._endIndex + 2);
            return new Result(c == 'T' ? leftResult._val : rightResult._val, rightResult._endIndex);
        }
        else {
            return new Result(c + "", startIndex);
        }
    }
    private class Result {
        String _val;
        int _endIndex;
        public Result(String val, int endIndex) {
            _val = val;
            _endIndex = endIndex;
        }
    }
}
