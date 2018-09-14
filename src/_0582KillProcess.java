import java.util.*;

public class _0582KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> tree = buildTree(pid, ppid);
        return dfs(kill, tree);
    }

    private Map<Integer, List<Integer>> buildTree(List<Integer> pid, List<Integer> ppid) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        Iterator<Integer> itp = pid.iterator();
        Iterator<Integer> itpp = ppid.iterator();

        while (itpp.hasNext()) {
            int pp = itpp.next();
            int p = itp.next();
            if (!tree.containsKey(pp)) {
                tree.put(pp, new ArrayList<>());
            }
            tree.get(pp).add(p);
        }
        return tree;
    }

    private List<Integer> dfs(int kill, Map<Integer, List<Integer>> tree) {
        List<Integer> result = new ArrayList<>();
        result.add(kill);
        if(tree.containsKey(kill)) {
            for(int child : tree.get(kill)){
                result.addAll(dfs(child, tree));
            }
        }
        return result;
    }
}
