package math;

import java.util.ArrayList;
import java.util.List;

class GetRow {
    public static void main(String[] args) {
        GetRow getRow = new GetRow();
        System.out.println(getRow.getRow(4));
    }
    public List<Integer> getRow(int rowIndex) {
        int t = 0;
        List<Integer> pre = new ArrayList<>();

        while(t <=rowIndex){
            t++;
            List<Integer> subList = new ArrayList<>();
            int[] arr = new int[t];
            for (int i = 0;i < t;i++){
                if (i == 0 || i ==t-1){
                    arr[i] = 1;
                }else {
                    arr[i] = pre.get(i-1) + pre.get(i);
                }
                subList.add(arr[i]);
            }
            pre = subList;
        }
        return pre;
    }
}