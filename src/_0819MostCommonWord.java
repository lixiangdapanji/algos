import java.util.*;

public class _0819MostCommonWord {
    /**
     *
     * @param s
     * @param banned
     * @return
     */
    public String mostCommonWord(String s, String[] banned) {

        List<String> arrStr = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isDelimiter(s.charAt(i))) {
               // if(!isDelimiter(s.charAt(i - 1))) {
                    arrStr.add(s.substring(start, i).toLowerCase());
               // }
                start = i + 1;
            }
        }
        if (!isDelimiter(s.charAt(s.length() - 1))) {
            arrStr.add(s.substring(start).toLowerCase());
        }
        List<String> bannedList = Arrays.asList(banned);
        Map<String, Integer> map = new HashMap<>();
        for (String word : arrStr) {
            if(!bannedList.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int max = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > max) {
                max = value;
            }
            result = entry.getKey();
        }
        return result;
    }
    private boolean isDelimiter(char c) {
        return (c == '!' || c == '.' || c == ' '|| c == '?' || c == ';' || c ==',');
    }
}