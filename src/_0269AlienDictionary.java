import java.util.*;

public class _0269AlienDictionary {
//    public String alienOrder(String[] words) {
//        Node[] graph = buildGraph(words);
//        return walkGraph(graph);
//    }
//
//    private String walkGraph(Node[] graph) {
//        StringBuilder sb = new StringBuilder();
//        boolean[] visitedGraph = new boolean[26];
//        boolean[] visitedNode = new boolean[26];
//        try{
//            for (int i = 0; i < 26; i++) {
//                dfs(graph, i, visitedGraph, visitedNode, sb);
//            }
//            return sb.reverse().toString();
//        } catch (RuntimeException e) {
//            return "";
//        }
//    }
//
//    private void dfs(Node[] graph, int id, boolean[] visitedGraph, boolean[] visitedNode, StringBuilder sb) {
//        if (visitedGraph[id]) {
//            return;
//        }
//        if (visitedNode[id]) {
//            throw new RuntimeException();
//        }
//        visitedNode[id] = true;
//        for (int child : graph[id]._neighbors) {
//            dfs(graph, child, visitedGraph, visitedNode, sb);
//        }
//        char c = (char)(id + 'a');
//        sb.append(c);
//
//        visitedGraph[id] = true;
//    }
//
//    private Node[] buildGraph(String[] words) {
//        Node[] graph = new Node[26];
//        // create Node
//        for (String word : words) {
//            for (int i = 0; i < word.length(); i++) {
//                char c = word.charAt(i);
//                if (graph[c - 'a'] == null) {
//                    graph[c - 'a'] = new Node(c - 'a');
//                }
//            }
//        }
//        // adjacency list
//        for (int i = 1; i < words.length; i++) {
//            int firstDif = 0;
//            while (firstDif < Math.min(words[i].length(), words[i - 1].length())) {
//                if (words[i].charAt(firstDif) != words[i - 1].charAt(firstDif)) {
//                    break;
//                }
//                firstDif++;
//            }
//            if (firstDif < Math.min(words[i].length(), words[i - 1].length())) {
//                char cDad = words[i - 1].charAt(firstDif);
//                char cSon = words[i].charAt(firstDif);
//                graph[cDad - 'a']._neighbors.add(cSon - 'a');
//            }
//        }
//        return graph;
//    }
//
//    private class Node {
//        final int _id;
//        List<Integer> _neighbors = new ArrayList<>();
//        public Node(int id) {
//            _id = id;
//        }
//    }


    public String alienOrder(String[] words) {
        Map<Character, ArrayList<Character>> graph = buildGraph(words);
        return topologicalSort(graph);
    }

    private String topologicalSort(Map<Character, ArrayList<Character>> graph) {
        Map<Character, Integer> indgree = buildIndegree(graph);
        Queue<Character> queue = new LinkedList<>();
        for (Character u : indgree.keySet()) {
            if (indgree.get(u) == 0) {
                queue.add(u);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            for (Character neighbor : graph.get(c)) {
                indgree.put(neighbor, indgree.get(neighbor) - 1);
                if (indgree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        if (sb.length() != indgree.size()) {
            return "";
        }
        return sb.toString();
    }

    private Map<Character, ArrayList<Character>> buildGraph(String[] words) {
        Map<Character, ArrayList<Character>> graph = new HashMap<>();

        //create nodes
        //
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new ArrayList<>());
                }
            }
        }

        //create edges
        for (int i = 1; i < words.length; i++) {
            int firstDif = 0;
            while (firstDif < Math.min(words[i].length(), words[i -1].length())) {
                if (words[i].charAt(firstDif) != words[i - 1].charAt(firstDif)) {
                    char cDad = words[i - 1].charAt(firstDif);
                    char cSon = words[i].charAt(firstDif);
                    graph.get(cDad).add(cSon);
                    break;
                }

            }
        }
        return graph;
    }

    private Map<Character, Integer> buildIndegree(Map<Character, ArrayList<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character u : graph.keySet()) {
            if (!indegree.containsKey(u)) {
                indegree.put(u, 0);
            } else {
                for (Character v : graph.get(u)) {
                    indegree.put(v, indegree.get(v) + 1);
                }
            }

        }
        return indegree;
    }
}
