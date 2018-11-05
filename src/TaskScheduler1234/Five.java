package TaskScheduler1234;
//如果tasks很多很多  但是cooldown time很小 如何优化空间复杂度到 O(cooldown time)注意这里顺序是不能变的 hint queue
import java.util.LinkedList;
import java.util.Queue;

public class Five {
    public  int completionInterval(char tasks[], int n) {
        int time = 0;
        Queue<Character> queue = new LinkedList<Character>();
        for(char c : tasks){
            if(!queue.contains(c)){
                //  exec straightly
                queue.add(c);
                if(queue.size()>n) queue.poll();
            }else{
                while(queue.size() <= n) {
                    queue.add('*');
                    time++;
                }
                while(queue.poll()!= c) time++;
                queue.add(c);
            }
            time++;
            System.out.println(time);

        }
        return time;
    }

}
