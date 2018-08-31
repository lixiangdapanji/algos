import java.util.*;

public class _0017LetterCombinationofaPhoneNumber {
    private static final String[] KEYS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        Queue<String> ans = new LinkedList<String>();
        if (digits.length() == 0) return (LinkedList)ans;
        ans.offer("");
        for(int i = 0; i < digits.length() ; i++){
            int x = Character.getNumericValue(digits.charAt(i));
            int size = ans.size();
            for (int j = 0 ; j < size; j++) {
                String t = ans.poll();
                for(char s : KEYS[x].toCharArray())
                    ans.offer(t+s);
            }
        }
        return (LinkedList)ans;
    }


//    public List<String> letterCombinations(String digits) {
//        List<String> res = new ArrayList<>();
//        if (digits == null || digits.length() == 0) {
//            return res;
//        }
//        backtrack(res, new StringBuilder(), digits, 0);
//        //dfs(res, new StringBuilder(), digits, 0);
//        return res;
//    }
//    private void backtrack(List<String> list, StringBuilder prefix, String digits, int pos) {
//        if (pos == digits.length()) {
//            list.add(prefix.toString());
//            return;
//        }
//        //int index = digits.charAt(pos) - '0';
//        String letters = KEYS[(digits.charAt(pos) - '0')];
//        for (int i = 0; i < letters.length(); i++) {
//            prefix.append(letters.charAt(i));
//            backtrack(list, prefix, digits, pos + 1);
//            prefix.deleteCharAt(prefix.length() - 1);
//        }
//    }

//    private void dfs(List<String> res, StringBuilder prefix, String digits, int pos) {
//        if (pos == digits.length()) {
//            res.add(prefix.toString());
//            return;
//        }
//        String letters = KEYS[(digits.charAt(pos) - '0')];
//        for (int i = 0; i < letters.length(); i++)
//            dfs(res, prefix.append(letters.charAt(i)), digits, pos + 1);
//    }
}
