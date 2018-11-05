package TaskScheduler1234;

import java.util.HashMap;
import java.util.Map;

//3. 有序，输出顺序【three】   往字符串里面放，记录下一次出现时，应该在的位置即可
public class Three {
    public String taskScheuler(char[] tasks, int cooldown) {
        if (tasks == null || tasks.length == 0) {
            return "";
        }
        int[] map = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : tasks) {
            if (map[c - 'A'] == 0) {
                sb.append(c);
                map[c - 'A'] = sb.length() - 1;
            } else {
                int prev = map[c - 'A'];
                //用当前的长度 - 之前的出现c的长度 - idle 的长度和cooldown判断
                if (sb.length() - prev - 1 < cooldown) {
                    int idleNeeded = cooldown - (sb.length() - prev - 1);
                    for (int i = 0; i < idleNeeded; i++) {
                        sb.append("idle");
                    }
                }
                sb.append(c);
                map[c - 'A'] = sb.length() - 1;
            }
        }
        return sb.toString();
    }
}