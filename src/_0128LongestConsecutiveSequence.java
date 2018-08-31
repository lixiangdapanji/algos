import java.util.*;

public class _0128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int left = 0;
                while (set.contains(num++)) {
                    left++;
                }
                res = Math.max(res, left);
            }
        }
        return res;
    }
}
