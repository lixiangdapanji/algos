public class _0748ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] s = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                s[Character.toLowerCase(c) - 'a']++;
            }
        }

        String res = "";
        int minLen = Integer.MAX_VALUE;

        for (String word : words) {
            if (word.length() >= minLen) {
                continue;
            }
            if (isMatch(word, s)) {
                minLen = word.length();
                res = word;
            }
        }
        return res;
    }
    private boolean isMatch(String word, int[] s) {
        int[] t = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                t[Character.toLowerCase(c) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (s[i] > t[i]) {
                return false;
            }
        }
        return true;
    }
}
