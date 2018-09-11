import java.util.HashMap;
import java.util.Map;

public class _0523ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0 && sum == k && sum % k == 0 && i > 0) {
                return true;
            }
            if (sum == 0 && i > 0) {
                return true;
            }
            if (k == 1 && i > 0) {
                return true;
            }
            if(k!=0) sum %= k;
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
