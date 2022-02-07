package queue;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author chengj
 * @Date 2021/10/30
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) throws Exception {
        CircleQueue queue = new CircleQueue(4);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        queue.add(50);
        System.out.println(queue.get());
    }

    static class CircleQueue{

        private int [] arr;

        private int maxSize;

        private int front;

        private int rear;

        public CircleQueue(int maxSize){
            this.maxSize = maxSize;
            arr = new int[maxSize];

        }
        //是否满了
        public boolean isFull(){
            return (rear+1)%maxSize == front;
        }
        //是否空了
        public boolean isEmpty(){
            return front == rear;
        }
        //添加数据
        public void add(int value){
            if (isFull()){
                System.out.println("队列已经满了");
            }
            arr[rear] = value;
            rear = (rear + 1)%maxSize;
        }
        //取出数据
        public int get() throws Exception {
            if (isEmpty()){
                throw new Exception("队列空了");
            }
            int value = arr[front];
            front = (front + 1)%maxSize;
            return value;
        }
        //有效数据的个数
        public int size(){
            return (rear + maxSize - front)%maxSize;
        }
    }
}
