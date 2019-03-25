import java.util.ArrayList;
import java.util.List;

public class _0089GrayCode {
    public static List<Integer> grayCode(int n) {
        if (n < 0)
            return new ArrayList<Integer>();
        if (n == 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            return list;
        }
        List<Integer> tmp = grayCode(n - 1);
        List<Integer> result = new ArrayList<Integer>(tmp);
        int addNumber = 1 << (n - 1);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            result.add(addNumber + tmp.get(i));
        }

        return result;
    }
}
