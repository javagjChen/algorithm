package queue;

/**
 * @Description
 * @Author chengj
 * @Date 2021/10/30
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

    }

    class ArrayQueue{

        private int [] arr;

        private int maxSize;

        private int front;

        private int rear;

        public ArrayQueue(int maxSize){
            maxSize = maxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;
        }
         public boolean isFull(){
            return rear == maxSize -1;
         }
         public boolean isEmpty(){
            return front == rear;
         }

         public void add(int value){
            if (isFull()){
                System.out.println("队列已经满了");
            }
            rear++;
            arr[rear] = value;
         }

         public int get() throws Exception {
            if (isEmpty()){
                throw new Exception("队列空了");
            }
            front++;
            return arr[front + 1];
        }
    }
}
