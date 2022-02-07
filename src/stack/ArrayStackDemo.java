package stack;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/5
 */
public class ArrayStackDemo {
    public static void main(String[] args) throws Exception {
        ArrayStack stack = new ArrayStack(4);
        stack.add(5);
        stack.add(4);
        stack.add(3);
        stack.add(2);
        stack.show();
        System.out.println("===========");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("===========");
        stack.show();
    }
}

class ArrayStack{
    //栈针
    public int peek;

    public int maxSize;

    private int [] arr;

    public ArrayStack(int maxSize) {
        peek = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return peek == maxSize -1;
    }

    public boolean isEmpty(){
        return peek == -1;
    }
    public void add(int value){
        if (isFull()){
            System.out.println("已经满了");
            return;
        }
        peek++;
        arr[peek] = value;
    }
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("栈空");
        }
        int val = arr[peek];
        peek--;
        return val;
    }
    public void show(){
        for (int i = peek;i >= 0;i--){
            System.out.println(arr[i]);
        }
    }
}
