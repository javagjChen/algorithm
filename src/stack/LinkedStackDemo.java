package stack;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/5
 */
public class LinkedStackDemo {
    public static void main(String[] args) throws Exception {
        LinkedStack stack = new LinkedStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.show();
        System.out.println("===================");
        System.out.printf("弹出的编号 %d \n",stack.pop());
        System.out.printf("弹出的编号 %d \n",stack.pop());
        System.out.printf("弹出的编号 %d \n",stack.pop());
        System.out.printf("弹出的编号 %d \n",stack.pop());

        System.out.println("====================");
        stack.show();
    }
}
class LinkedStack{
    public int peek;
    public SingleLinked head;

    public LinkedStack() {
        //head = new SingleLinked(-1);
    }

    public void add(int value){
        SingleLinked linked = new SingleLinked(value);
        linked.next = head;
        head = linked;
    }

    public void show(){
        SingleLinked temp = head;
        while (temp != null){
            System.out.println(temp.no);
            temp = temp.next;
        }
    }
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("栈空");
        }
        SingleLinked temp = head;
        head = temp.next;
        return temp.no;
    }
}
class SingleLinked{
    public int no;
    public SingleLinked next;

    public SingleLinked(int no) {
        this.no = no;
    }
}
