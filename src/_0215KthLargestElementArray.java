public class _0215KthLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
        //找第（n -k + 1）小
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int quickSelect(int[] a, int start, int end, int k) {
        // 第k绝对小，不是第k相对小
        //shuffle 保证每次
        int pivot = a[end];

        int i = start;
        int front = start - 1;
        int back = end + 1;
        while (i != back) {
            if (a[i] < pivot) {
                front++;
                swap(a, front, i);
                i++;
            } else if (a[i] == pivot) {
                i++;
            } else {
                back--;
                swap(a, i, back);
            }
        }

        if (front + 2 <= k && k <= back) {
            return a[k - 1]; //第k大的数从1开始的
        } else if (k < front + 2) {
            return quickSelect(a, start, front, k);
        } else {
            return quickSelect(a, back, end, k);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
