import java.util.ArrayList;
import java.util.List;

public class _0658FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-1;
        int pos = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] <= x){
                start = mid + 1;
                pos = mid;
            } else {
                end = mid - 1;
            }
        }
        //ensure the range
        start = pos;
        end = pos + 1;
        while (k > 0) {
            if (end >= arr.length || (start >= 0 && x-arr[start] <= arr[end] - x)) {
                start--;
            } else {
                end++;
            }
            k--;
        }

        List<Integer> list =new ArrayList<>();
        for(int i = start + 1; i < end; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
