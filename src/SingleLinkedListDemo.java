import java.util.Stack;

/**
 * @Description
 * @Author chengj
 * @Date 2021/11/3
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new SingleNode(1,"乔帮主"));
        singleLinkedList.add(new SingleNode(2,"金庸"));
        singleLinkedList.add(new SingleNode(3,"雪山飞狐"));
        singleLinkedList.show();
        singleLinkedList.reverse();
        singleLinkedList.show();
    }
}

class SingleLinkedList{

    public SingleNode head = new SingleNode(0,"头");

    public void add(SingleNode node){
        SingleNode temp = head;
        while (true){
            if (temp.next == null){
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void show(){
        SingleNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.printf("节点信息,编号: %d,名称: %s \n",temp.no,temp.name);
            temp = temp.next;
        }
    }

    public void reverse() {
        Stack<SingleNode> stack = new Stack<>();
        SingleNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            stack.push(temp.next);
            temp = temp.next;
        }
        SingleNode temp2 = stack.pop();
        SingleNode cur = temp2;
        while (!stack.isEmpty()){
            SingleNode node = stack.pop();
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }
        head.next = temp2;
    }
}

class SingleNode {
    public Integer no;
    public String name;
    public SingleNode next;

    public SingleNode(Integer no,String name) {
        this.no = no;
        this.name = name;
    }
}