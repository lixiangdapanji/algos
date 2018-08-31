import java.util.HashMap;
import java.util.Map;

public class _0781RabbitsinForest {
    public int numRabbits(int[] answers) {
        int result = 0;
        // key 是不同颜色的兔子

        Map<Integer, Integer> sumToAnswer = new HashMap<>();
        for (int answer : answers) {
            int sum = answer + 1;
            if (sumToAnswer.containsKey(sum)) {
                sumToAnswer.put(sum, sumToAnswer.get(sum) + 1);
            } else {
                sumToAnswer.put(sum, 1);
            }
//            if (sumToAnswer.get(sum) == sum) {
//                result += sum;
//                sumToAnswer.remove(sum);
//            }
        }
        for (Map.Entry<Integer, Integer> entry : sumToAnswer.entrySet()) {
            result += entry.getKey();
        }
        return result;
    }
}
