import java.util.Arrays;

public class _9995TrangleForm {
    //三条边是否能组成三角形
    public boolean canForm (int[] a) {
        //a[i - 1] + a[i] > a[i + 1]
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] + a[i] > a[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = i + 2;
            if (nums[i] != 0) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                        k++;
                    }
                    count += k - j - 1;
                }
            }
        }
        return count;
    }
}