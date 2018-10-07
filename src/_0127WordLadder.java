import java.util.*;

public class _0127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> addedToQueue = new HashSet<>();
        addedToQueue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                //1 op at node
                // do nothing

                //2 children
                for (int index = 0; index < cur.length(); index++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String next = new StringBuilder(cur).replace(index, index + 1, c + "").toString();
                        if (dict.contains(next) && next.equals(endWord)) {
                            return level + 1;
                        }

                        if (dict.contains(next) && !addedToQueue.contains(next)) {
                            queue.add(next);
                            addedToQueue.add(next);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

