import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _0528RandomPickwithWeight {
    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public _0528RandomPickwithWeight(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);
        int start = 0;
        int pos = -1;
        int end = psum.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (targ >= psum.get(mid)) {
                pos = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pos;
    }
}