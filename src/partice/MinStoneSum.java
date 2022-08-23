package partice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/23
 */
public class MinStoneSum {

    public static void main(String[] args) {
        MinStoneSum mss = new MinStoneSum();
        int[] piles = new int[]{4,3,6,7};
        System.out.println(mss.minStoneSum(piles,3));
    }
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int val : piles){
            priorityQueue.add(val);
        }
        while (k >0){
            k--;
            Integer poll = priorityQueue.poll();
            poll = poll - poll/2;
            priorityQueue.add(poll);
        }
        int sum = 0;
        while (!priorityQueue.isEmpty()){
            sum += priorityQueue.poll();
        }
        return sum;
    }
}
