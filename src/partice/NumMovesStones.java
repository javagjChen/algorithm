package partice;

import java.util.Arrays;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/23
 */
public class NumMovesStones {
    public static void main(String[] args) {
        NumMovesStones nms = new NumMovesStones();
        System.out.println(Arrays.toString(nms.numMovesStones(1,3,5)));
    }
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        if(arr[2] - arr[1] == 1 && arr[1] - arr[0] == 1){
            return new int[]{0,0};
        }
        int max = 0;
        // 其中有两个数是挨着的
        if(arr[2] - arr[1] == 1 || arr[1] - arr[0] == 1){
            max = Math.max(arr[2] - arr[1] ,arr[1] - arr[0]) -1;
            return new int[]{1,max};
        }
        // 剩下只有都不挨着的情况
        int one = (arr[2] - arr[1] - 1) + ( arr[1] - arr[0] -1);
        // 中间空着一位
        if(arr[2] - arr[1] == 2 || arr[1] - arr[0] == 2){
            return new int[]{1,one};
        }
        return new int[]{2,one};
    }
}
