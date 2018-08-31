public class _9996ShiftArray {
    public void shift(int[] array, int start, int end) {
        int tmp = array[end];
        for (int i = end; i > start; i--) {
            array[i] = array[i -1];
        }
        array[start] = tmp;
    }
}
