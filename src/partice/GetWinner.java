package partice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/31
 */
public class GetWinner {

    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1;i < n;i++){
            queue.add(arr[i]);
            if (max < arr[i]){
                max = arr[i];
            }
        }
        if (k > n -1){
            return max;
        }
        int base = arr[0];
        int count = 0;
        while (true){
            Integer poll = queue.poll();
            if (base > poll){
                count++;
                queue.add(poll);
            }else {
                queue.add(base);
                base = poll;
                count = 1;
            }
            if (count == k){
                return base;
            }
        }
    }

    public int getWinner2(int[] arr,int k){
        int n = arr.length;
        int max = Math.max(arr[0],arr[1]);
        if(k == 1){
            return max;
        }
        int count = 1;
        for (int i = 2;i < n;i++){
            if (max > arr[i]){
                count++;
            }else {
                max = arr[i];
                count = 1;
            }
            if (count == k){
                return max;
            }
        }

        return max;
    }
}
