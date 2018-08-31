import java.util.HashMap;
import java.util.Map;

public class _0833FindAndReplaceinString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S.length() == 0) {
            return "";
        }

        Map<Integer, Integer> stringIndexToArrayIndex = new HashMap<>();

        for (int i = 0; i < indexes.length; i++) {
            if (S.length() - indexes[i] >= sources[i].length()) {
                if (S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])) {
                    stringIndexToArrayIndex.put(indexes[i], i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (stringIndexToArrayIndex.containsKey(i)) {
                int arrayIndex = stringIndexToArrayIndex.get(i);
                sb.append(targets[arrayIndex]);
                i += sources[arrayIndex].length() - 1;
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}
