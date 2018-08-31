public class _0243ShortestWordDistance {
    /**
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            int tmp = 0;
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
                }
            if(index1 != -1 && index2 != -1) {
                tmp = Math.abs(index1- index2);
                if (res > tmp) {
                    res = tmp;
                }
            }

        }
        return res;
    }
}
