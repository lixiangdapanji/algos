import java.util.*;

public class _0721AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> name = nameGraph(accounts);
        Map<String, Set<String>> email = emailGraph(accounts);
        return walkGraph(name, email);
    }
    private Map<String, String> nameGraph(List<List<String>> accounts) {
        Map<String, String> name = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                name.put(account.get(i), account.get(0));
            }
        }
        return name;
    }
    private Map<String, Set<String>> emailGraph(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                if (i == 1) {
                    continue;
                }
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        return graph;
    }
    private List<List<String>> walkGraph(Map<String, String> name, Map<String, Set<String>> graph) {
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        for (String email : name.keySet()) {
            List<String> list = new LinkedList<>();
            if (!visited.contains(email)) {
                list.add(email);
                visited.add(email);
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }
        return res;
    }
    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        for (String next : graph.get(email)) {
            if (!visited.contains(next)) {
                list.add(next);
                visited.add(next);
                dfs(graph, next, visited, list);
            }
        }
    }
}
