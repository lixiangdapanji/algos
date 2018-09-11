import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0648ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> wordSet = new HashSet();
        for (String word : dict) wordSet.add(word);

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (wordSet.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }
}