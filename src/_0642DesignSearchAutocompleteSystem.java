import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _0642DesignSearchAutocompleteSystem {
    public Trie trie;
    public TrieNode root;
    public String prefix;
    public _0642DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        root = trie.root;
        prefix = "";
        for (int i = 0; i < times.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> (a.freq == b.freq) ? (a.token.compareTo(b.token)) : b.freq - a.freq);
        if (c == '#')   {
            root = trie.root;
            trie.insert(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        prefix = prefix + c;
        root = trie.searchHelper(prefix);
        trie.addToPQ(root, pq, prefix);
        for (int i = 1; i <= 3; i++){
            if (pq.size() > 0)
                list.add(pq.poll().token);
        }
        return list;
    }

    class Pair {
        String token;
        int freq;
        Pair(String token, int freq){
            this.token = token;
            this.freq = freq;
        }
    }


    class TrieNode{
        int freq;
        TrieNode[] children;
        public TrieNode() {
            freq = 0;
            children = new TrieNode[27];
        }
    }

    class Trie {
        public TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word, int f) {
            TrieNode ws = root;
            for (char ch: word.toCharArray()) {
                int id = ch - 'a';
                if (ch == ' ')  id = 26;
                if (ws.children[id] == null)
                    ws.children[id] = new TrieNode();
                ws = ws.children[id];
            }
            ws.freq += f;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode ws = searchHelper(word);
            return ws != null && ws.freq > 0;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchHelper(prefix) != null;
        }

        public TrieNode searchHelper(String str) {
            TrieNode ws = root;
            for (char ch: str.toCharArray()){
                int id = ch - 'a';
                if (ch == ' ')  id = 26;
                if (ws == null) return null;
                ws = ws.children[id];
            }
            return ws;
        }

        public void addToPQ(TrieNode root, PriorityQueue<Pair> pq, String prefix) {
            if (root == null)   return;
            if (root.freq > 0)   pq.offer(new Pair(prefix, root.freq));
            for (int i = 0; i < 27; i++) {
                if (root.children[i] != null) {
                    char ch = ' ';
                    if (i != 26)    ch = (char) ('a' + i);
                    addToPQ(root.children[i], pq, prefix + ch);
                }
            }
        }
    }
}
