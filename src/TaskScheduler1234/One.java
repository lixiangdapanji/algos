package TaskScheduler1234;
//1. 无序，输出时间【one】    使用数学方法计算，理论上的idles数量 - 可以用来填充idle的task的数量 = 真正需要的idle的数量（一定要大于0）
public class One {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] > maxFreq) {
                maxFreq = map[i];
            }
        }
        int cnt = 0;
        for (int num : map) {
            if (num == maxFreq) {
                cnt++;
            }
        }
        //n 为slot 1 为idle cnt 为和最大频率相同的元素
        int res = (n + 1) * (maxFreq - 1) + cnt;
        return Math.max(res, tasks.length);
    }
}
//["A","A","A","B","B","B"], n = 2
//A -> B -> idle -> A -> B -> idle -> A -> B.
// (n + 1) * (MAXfreq - 1)
//
