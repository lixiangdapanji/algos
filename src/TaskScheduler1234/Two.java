package TaskScheduler1234;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//2. 无序，输出顺序【two】     使用优先队列，在每一个block块中，总是把还剩的数量最多的字符放在前面【当前数量最多，那么，之前一定也是数量最多】
public class Two {
    public String leastInterval(char[] tasks, int n) {
        //Map<Character, Integer> counts = new HashMap<>();
        int[] counts = new int[26];
        for (char c : tasks) {
            //counts.put(t, counts.getOrDefault(t, 0) + 1);
            counts[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> counts[b]- counts[a]);
        //pq.addAll(counts.values());
        for (int k = 0; k < 26; k++) {
            if (counts[k] > 0) {
                pq.add(k);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int i = 0;
            for (;i < cycle; i++) {
                if (!pq.isEmpty()) {
                    int c = pq.poll();
                    sb.append(c + "A");
                    counts[c]--;
                    tmp.add(c);
                }
            }
            // add them to the pq after one round
            for (int m : tmp) {
                if (counts[m] > 0) {
                    pq.offer(m);
                }
            }
            // if the len < cycle
            for (int j = i; j < cycle; j++) {
                sb.append("idle");
            }
        }
        return sb.toString();
    }
}

