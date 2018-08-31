public class _9998QuickSort {
    public void quickSort(int[] a) {
        partition(a,0, a.length);
    }
    private void partition(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end - start) / 2 + start;
        int pivot = a[mid];
        int left = start;
        int right = end;

        while (left <= right) {
            while (left <= right && a[left] < pivot) {
                left++;
            }
            while (left <= right && a[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }
        }
        partition(a,start,right);
        partition(a,left,end);
    }
}
