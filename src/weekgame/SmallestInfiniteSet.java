package weekgame;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/10
 */
public class SmallestInfiniteSet {

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }

    public LinkedList<Integer> queue;


    public SmallestInfiniteSet() {
        queue = new LinkedList();
        for (int i = 1;i < 1001;i++){
            queue.add(i);
        }
    }

    public int popSmallest() {
        return queue.pollFirst();
    }

    public void addBack(int num) {
        if (!queue.contains(num)){
            int n = queue.size();
            int[] arr = new int[n + 1];
            int index = 0;
            boolean flag = true;
            while (!queue.isEmpty()){
                Integer first = queue.peekFirst();
                if (first < num){
                    arr[index] = queue.pollFirst();
                }else {
                    if (flag){
                        arr[index] = num;
                        flag = false;
                    }else {
                        arr[index] = queue.pollFirst();
                    }
                }
                index++;
            }

            for (int i = 0;i < arr.length;i++){
                queue.add(arr[i]);
            }

        }
    }
}
