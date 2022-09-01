package partice;

import java.util.Arrays;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/30
 */
public class NumSmallerByFrequency {

    public static void main(String[] args) {
        NumSmallerByFrequency nsbf = new NumSmallerByFrequency();
        System.out.println(nsbf.f("cbb"));
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] helper = new int[words.length];
        for (int i = 0;i < words.length;i++){
            helper[i] = f(words[i]);
        }
        Arrays.sort(helper);
        for (int i = 0;i < n;i++){
            //int count = 0;
            int t = f(queries[i]);
            int l = -1;
            int r = words.length;
            while (l + 1 != r){
                int mid = l + (r - l)/2;
                if (helper[mid] <= t){
                    l = mid;
                }else {
                    r = mid;
                }
            }
            if (r == words.length){
                ans[i] = 0;
            }else {
                ans[i] = words.length - r;
            }

        }
        return ans;
    }

    public int f(String str){
        char c = str.charAt(0);
        int count = 1;
        for (int i=1;i<str.length();i++){
            char temp = str.charAt(i);
            if (temp==c)
                count++;
            else if (temp<c){
                c=temp;
                count=1;
            }
        }
        return count;
    }
}
