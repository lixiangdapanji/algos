package TaskScheduler1234;
//4. 有序，输出时间【four】
public class Four {
    /**
     *      map用来记录如果再次出现当前task时，理论上应该出现的位置
     *      cnt用来记录当前的的长度
     *
     *          当task存在于map中时，如果理论上应该出现的位置在当前rst的数量后面，则更新rst
     */
    public int taskScheduler(char[] tasks, int cooldown) {
        int[] map = new int[26];
        int cnt = 0;
        for (char c : tasks) {
            int n = c - 'A';
            if (map[n] > cnt) {
                cnt = map[n];
            }
            map[n] = cnt + cooldown + 1;
            cnt++;
        }
        return cnt;
    }
}
