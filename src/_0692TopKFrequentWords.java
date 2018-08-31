import java.util.*;

public class _0692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        WordsComparator comparator = new WordsComparator();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comparator);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(pq.size() < k) {
                pq.add(entry);
            } else {
                int compareResult =comparator.compare(entry, pq.peek());
                if (compareResult > 0) {
                    pq.poll();
                    pq.add(entry);
                }
            }
        }
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        return result;
    }

    private class WordsComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return Integer.compare(o1.getValue(), o2.getValue()) != 0
                    ? Integer.compare(o1.getValue(), o2.getValue())
                    : o2.getKey().compareTo(o1.getKey());
        }
    }
}
