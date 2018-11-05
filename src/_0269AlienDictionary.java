import java.util.ArrayList;
import java.util.List;

public class _0269AlienDictionary {
    public String alienOrder(String[] words) {
        Node[] graph = buildGraph(words);
        return walkGraph(graph);
    }
    private String walkGraph(Node[] graph) {
        StringBuilder sb = new StringBuilder();
        boolean[] visitedGraph = new boolean[26];
        boolean[] visitedNode = new boolean[26];

        try{
            for (int i = 0; i< 26; i++) {
                if (graph[i] != null) {
                    dfs(graph, i, visitedGraph, visitedNode, sb);
                }
            }
            return sb.reverse().toString();
        } catch (RuntimeException e) {
            return "";
        }
    }

    private void dfs(Node[] graph, int id, boolean[] visitedGraph, boolean[] visitedNode, StringBuilder result) {
        if (visitedGraph[id]) {
            return;
        }
        if (visitedNode[id]) {
            throw new RuntimeException("cycle");
        }
        visitedNode[id] = true;

        for (int childId : graph[id]._neighborIds) {
            dfs(graph, childId, visitedGraph, visitedNode, result);
        }
        char c = (char) (id + 'a');
        result.append(c);

        visitedGraph[id] = true;
    }


    private Node[] buildGraph(String[] words) {
        Node[] graph = new Node[26];
        // 1 node
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char cI = word.charAt(i);
                if (graph[cI - 'a'] == null) {
                    graph[cI - 'a'] = new Node(cI - 'a');
                }
            }
        }
        //2 adjacency list
        for (int i = 1; i < words.length; i++) {
            int firstDiffIndex = 0;
            while (firstDiffIndex < Math.min(words[i].length(), words[i - 1].length())) {
                if (words[i].charAt(firstDiffIndex) != words[i - 1].charAt(firstDiffIndex)) {
                    break;
                }
                firstDiffIndex++;
            }
            if (firstDiffIndex < Math.min(words[i].length(), words[i -1].length())) {
                // 
                char cDad = words[i - 1].charAt(firstDiffIndex);
                char cSon = words[i].charAt(firstDiffIndex);
                graph[cDad - 'a']._neighborIds.add(cSon - 'a');
            }
        }
        return graph;
    }

    private class Node {
        final int _id;
        List<Integer> _neighborIds = new ArrayList<>();
        public Node(int id) {
            _id = id;
        }
    }

}
