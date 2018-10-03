import java.util.ArrayList;
import java.util.List;

public class _0282ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(res, sb, target, num, 0, 0, 0);
        return res;
    }
    private void helper(List<String> res, StringBuffer sb, int target, String num, long prev, long sum, int index) {
        if (index == num.length()) {
            if (sum == target) {
                res.add(new String(sb));
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            int len = sb.length();
            long temp = Long.valueOf(num.substring(index, i + 1));
            if (index == 0) {
                helper(res, sb.append(temp), target, num, temp, temp, i + 1);
                sb.setLength(len);
            } else {
                sb.append("+");
                sb.append(temp);
                helper(res, sb, target, num, temp, sum + temp, i + 1);
                sb.setLength(len);

                sb.append("-");
                sb.append(temp);
                helper(res, sb, target, num, -temp, sum - temp, i + 1);
                sb.setLength(len);

                sb.append("*");
                sb.append(temp);
                helper(res, sb, target, num, prev * temp, sum - prev + prev * temp, i + 1);
                sb.setLength(len);
            }
        }
    }
}