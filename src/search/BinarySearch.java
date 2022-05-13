package search;

/**
 * @Description
 * @Author chengj
 * @Date 2021/12/2
 */
public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = new int[]{1,8,23,54,67,89,102};
        System.out.println(binarySearch(arr,0,arr.length-1,89));
    }

    public static int binarySearch(int [] arr,int left,int right,int findVal){

        if (left > right){
            return -1;
        }
        int mid = left + ((right - left) >>1);
        if (findVal > arr[mid]){
            return binarySearch(arr,mid + 1,right,findVal);
        }else if (findVal < arr[mid]){
            return binarySearch(arr,left,mid -1,findVal);
        }else {
            return mid;
        }
    }
}
