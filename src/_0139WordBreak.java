import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0139WordBreak {
    public int wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        int[] dp = new int[s.length() + 1];
        // if the substring is "" we can still match
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //j is the break point that store the previous result to j
                if (dp[j] != -1
                        && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[j] + 1, dp[i] == -1 ? Integer.MAX_VALUE : dp[i]);
                }
            }
        }
        return dp[s.length()];
    }
}
