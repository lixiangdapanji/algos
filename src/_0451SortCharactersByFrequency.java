import java.util.ArrayList;
import java.util.List;

public class _0451SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        List<Character>[] array = new List[s.length()];
        for (char c : s.toCharArray()) {
            int n = map[c];
            if (array[n] == null) {
                array[n] = new ArrayList<>();
            }
            if (!array[n].contains(c)) {
                array[n].add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] != null) {
                for (char c : array[i]) {
                    //for (int j = 0; j < i; j++) {
                        sb.append(c);
                   // }
                }
            }
        }
        return sb.toString();
    }
}