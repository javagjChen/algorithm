package stack;

import java.util.Stack;

/**
 * @Description
 * @Author chengj
 * @Date 2022/1/7
 */
public class TwoStackQueue {

    private Stack<Integer> pushStack;

    private Stack<Integer> popStack;

    public TwoStackQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(Integer val){
        popToPush();
        pushStack.push(val);
    }

    public Integer pop(){
        pushToPop();
        return popStack.pop();
    }

    public void pushToPop(){
        if (!pushStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }

    }
    public void popToPush(){
        if (!popStack.isEmpty()){
            while (!popStack.isEmpty()){
                pushStack.push(popStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.pop());
        queue.add(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
