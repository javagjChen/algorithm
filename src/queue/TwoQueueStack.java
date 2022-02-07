package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author chengj
 * @Date 2022/1/7
 */
public class TwoQueueStack {

    private Queue<Integer> oneQueue;

    private Queue<Integer> twoQueue;

    public TwoQueueStack() {
        this.oneQueue = new LinkedList<>();
        this.twoQueue = new LinkedList<>();
    }

    public void add(Integer val){
        if (!oneQueue.isEmpty()){
            oneQueue.add(val);
        }else {
            twoQueue.add(val);
        }
    }

    public Integer pop(){
        if (!oneQueue.isEmpty()){
            while (oneQueue.size() > 1){
                 twoQueue.add(oneQueue.poll());
            }
            return oneQueue.poll();
        }else {
            while (twoQueue.size() > 1){
                oneQueue.add(twoQueue.poll());
            }
            return twoQueue.poll();
        }
    }

    public static void main(String[] args) {
        TwoQueueStack stack  = new TwoQueueStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.add(6);
        System.out.println(stack.pop());
    }
}
