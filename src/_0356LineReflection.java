import java.util.*;
public class _0356LineReflection {
    public boolean isReflected(int[][] points) {
        if (points.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> yToXs = new HashMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            if (yToXs.containsKey(y)) {
                Set<Integer> set = yToXs.get(y);
                set.add(x);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(x);
                yToXs.put(y, set);
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


       // Iterator<Map.Entry<Integer, Set<Integer>>> it = yToXs.entrySet().iterator();
       // Set<Integer> set0 = it.next().getValue();
        for (Map.Entry<Integer, Set<Integer>> entry : yToXs.entrySet()) {
         Set<Integer> set0 = entry.getValue();
            for (int x : set0) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
        }
        // Set<Integer> set0 = it.next().getValue();
        // for (int x : set0) {
        //     min = Math.min(min, x);
        //     max = Math.max(max, x);
        // }
        double mid = min + (max - min) / 2.0;

//        for (Map.Entry<Integer, Set<Integer>> entry : yToXs.entrySet()) {
//            Set<Integer> set = entry.getValue();
//            for (int x : set) {
//                int reflect = (int) (mid * 2 - x);
//                if (!set.contains(reflect)) {
//                    return false;
//                }
//            }
//        }
        Iterator<Map.Entry<Integer, Set<Integer>>> it2 = yToXs.entrySet().iterator();
        Set<Integer> set2 = it2.next().getValue();
        for (int x : set2) {
            int reflect = (int) (mid * 2 - x);
            if (!set2.contains(reflect)) {
                return false;
            }
        }
        return true;
    }
}
