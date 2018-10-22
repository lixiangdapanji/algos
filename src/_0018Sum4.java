import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sum3;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++ ) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            sum3 = threeSum(nums, target - nums[i], i + 1);
            for (List<Integer> list : sum3) {
                if (!list.isEmpty()) {
                    list.add(nums[i]);
                    res.add(new ArrayList(list));
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int tar, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = start; i < nums.length - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = tar -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}

