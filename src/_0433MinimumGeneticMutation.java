import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _0433MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }

        char[] ACGT = new char[]{'C', 'A', 'T', 'G'};
        Set<String> bankSet = new HashSet<String>();
        for (String word : bank) {
            bankSet.add(word);
        }
        if(!bankSet.contains(end)) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            String word = cur._word;
            int level = cur._level;

            if (word.equals(end)) {
                return level;
            }

            char[] wordArr = word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                for (int j = 0; j < 4; j++) {
                    char temp = wordArr[i];
                    if(wordArr[i] != ACGT[j])
                    {
                        wordArr[i] = ACGT[j];
                    }

                    String newWord = new String(wordArr);
                    if(bankSet.contains(newWord))
                    {
                        queue.add(new Node(newWord, level+1));
                        bankSet.remove(newWord);
                    }

                    wordArr[i] = temp;
                }
            }
        }
        return -1;
    }
    private class Node {
        String _word;
        int _level;

        public Node(String word, int level) {
            _word = word;
            _level = level;
        }
    }
}
