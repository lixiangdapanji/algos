public class _0080RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // i = 0;
        int len = 1;
        // i = 1;
        len = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] != nums[i]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
