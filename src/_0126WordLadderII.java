import java.util.*;

public class _0126WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        //Graph
        //store the relation between the one step change to next one
        HashMap<String, List<String>> parentsToChildren = new HashMap<>();
        //distance of every node from the start node
        HashMap<String, Integer> distance = new HashMap<>();

        buildGraph(beginWord, endWord, wordSet, parentsToChildren, distance);
        walkGraph(beginWord, endWord, wordSet, parentsToChildren, distance, result, list);

        return result;
    }
    //BFS
    private void buildGraph(String start, String end, Set<String> wordSet, HashMap<String, List<String>> parentsToChildren, HashMap<String, Integer> distance) {
        for (String word : wordSet) {
            parentsToChildren.put(word, new ArrayList<String>());
        }



        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> addedToQueue = new HashSet<>();
        addedToQueue.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isFound = false;
            for (int i = 0; i < size; i++) {

                String cur = queue.poll();
                int disCur = distance.get(cur);

                //ArrayList<String> neighbors = new ArrayList<>();

                for (int index = 0; index < cur.length(); index++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String next = new StringBuilder(cur).replace(index, index + 1, c + "").toString();
                        if (wordSet.contains(next) && !addedToQueue.contains(next)) {
                            if (parentsToChildren.get(cur) == null) {
                                parentsToChildren.put(cur, new ArrayList<>());
                            }
                            parentsToChildren.get(cur).add(next);

                            if (!distance.containsKey(next)) {// Check if visited
                                distance.put(next, disCur + 1);
                            }
                            if (end.equals(next)){// Found the shortest path
                                isFound = true;
                            } else {
                                queue.add(next);
                                addedToQueue.add(next);

                            }
                        }
                    }
                }
                if (isFound) {
                    break;
                }

            }
        }
    }
    //DFS
    private void walkGraph(String start, String end, Set<String> wordSet, HashMap<String, List<String>> parentsToChildren, HashMap<String, Integer> distance, List<List<String>> result, List<String> list) {
        //op at node
        list.add(start);

        if (end.equals(start)) {
            result.add(new ArrayList<String>(list));
        } else {
            for (String next : parentsToChildren.get(start)) {
                if (distance.get(next) == distance.get(start) + 1) {
                    walkGraph(next, end, wordSet, parentsToChildren, distance, result, list);
                }
            }
        }
        list.remove(list.size() - 1);
    }
}

