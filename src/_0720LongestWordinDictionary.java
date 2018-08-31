public class _0720LongestWordinDictionary {
    public String longestWord(String[] words) {
        TrieNode root = buildTrie(words);
        StringBuilder path = new StringBuilder();
        StringBuilder result = new StringBuilder();
        walkTrie(root, null, result, path);
        return result.toString();
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode fakeRoot = new TrieNode('x');

        for (String word : words) {
            TrieNode cur = fakeRoot;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode next = cur._children[c -'a'];
                if (next == null) {
                    next = new TrieNode(c);
                    cur._children[c - 'a'] = next;
                }
                cur = next;
            }
            cur._isWord = true;
        }
        return fakeRoot;
    }

    private void walkTrie(TrieNode node, TrieNode parent, StringBuilder result, StringBuilder path) {
        //1 op at node
        if (parent != null) {
            path.append(node._id);
        }

        if ((path.length() == 1 && node._isWord)||
                (parent != null && parent._canBeBuilt && node._isWord)) {
            node._canBeBuilt = true;
            if (result.length() < path.length()) {
                result.delete(0, result.length());
                result.append(path);
            }
        }

        //2 go down to children
        for (TrieNode child : node._children) {
            if (child != null) {
                walkTrie(child, node, result, path);
            }
        }

        // go up to parent
        if (parent != null) {
            path.deleteCharAt(path.length() - 1);
        }
    }

    private class TrieNode {
        final char _id;
        boolean _isWord;
        boolean _canBeBuilt;
        TrieNode[] _children = new TrieNode[26];
        public TrieNode (char id) {
            _id = id;
        }
    }
}

