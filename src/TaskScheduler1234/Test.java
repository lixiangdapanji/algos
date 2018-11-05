package TaskScheduler1234;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public int lonelyInteger(List<Integer> arr) {
        // Write your code here
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res++;
            }
        }
        return res;
    }

}
