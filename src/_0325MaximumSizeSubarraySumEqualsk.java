import java.util.HashMap;
import java.util.Map;

public class _0325MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> sumFirstIndex = new HashMap<>();
        sumFirstIndex.put(0, -1);
        int sum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumFirstIndex.containsKey(sum - k)) {
                result = Math.max(result, i - sumFirstIndex.get(sum - k)); //不需要+1
            }
            if (!sumFirstIndex.containsKey(sum)) {
                sumFirstIndex.put(sum, i);
            }
        }
        return result;
    }
}
