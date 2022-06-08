package binarysearch;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author chengj
 * @Description 1337.矩阵中战斗力最弱的 K 行 简单
 * @Date 2022/6/8
 */
public class KWeakestRows {

    public static void main(String[] args) {
        KWeakestRows kwr = new KWeakestRows();
        int[][] mat = new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 2;
        System.out.println(Arrays.toString(kwr.kWeakestRows(mat,k)));
    }
    /**
     *
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] arr = new int[m];
        for (int i = 0;i < m; i++){
            int l = -1;
            int r = n;
            while (l + 1 != r ){
                int mid = l + (r - l)/2;
                if (mat[i][mid] > 0){
                    l = mid;
                }else {
                    r = mid;
                }
            }
            arr[i] = r*m+i;
        }
        int[] ans = new int[k];
        Arrays.sort(arr);
        for (int i =  0;i < k; i++){
            ans[i] = arr[i]%m;
        }
        return ans;
    }
}
