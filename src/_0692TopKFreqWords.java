import java.util.*;

public class _0692TopKFreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        for (String word : words) {
            if (trie.search(word) == false) {
                trie.insert(word);
            }
        }

        WordsComparator comparator = new WordsComparator();
        PriorityQueue<Node> pq = new PriorityQueue(comparator);

        for (String word : words) {
            Node node = new Node (word, new Trie().find(word));
            if(pq.size() < k) {
                pq.add(node);
            } else {
                int compareResult = comparator.compare(node, pq.peek());
                if (compareResult > 0) {
                    pq.poll();
                    pq.add(node);
                }
            }
        }

        List<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll()._word);
        }
        return res;
    }

    private class Node {
        String _word;
        Trie.TrieNode _trieNode;
        public Node (String word, Trie.TrieNode trieNode) {
            _word = word;
            _trieNode = trieNode;
        }
    }

    private class WordsComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1._trieNode.freq == o2._trieNode.freq ? (o1._word).compareTo(o2._word) : Integer.compare(o2._trieNode.freq, o1._trieNode.freq);
        }
    }

    private class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int id = c - 'a';
                if (p.children[id] == null) {
                    p.children[id] = new TrieNode();
                }
                p = p.children[id];
            }
            p.freq = 1;
            p.isWord = true;
        }

        private TrieNode find(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    return null;
                }
                p = p.children[c - 'a'];
            }
            p.freq += 1;
            return p;
        }

        public boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isWord;
        }

        private class TrieNode {
            boolean isWord;
            TrieNode[] children;
            int freq;
            public TrieNode() {
                isWord = false;
                children = new TrieNode[26];
                freq = 0;
            }
        }
    }
}
