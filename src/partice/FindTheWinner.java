package partice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/19
 */
public class FindTheWinner {
    public static void main(String[] args) {
        FindTheWinner ftw = new FindTheWinner();
        System.out.println(ftw.findTheWinner(6,5));
    }
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1;i <= n;i++){
            queue.add(i);
        }
        while (queue.size() > 1){
            for (int i = 1;i < k;i++){
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
