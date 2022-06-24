package binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chengj
 * @Description 436.寻找右区间 中等
 * @Date 2022/6/24
 */
//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
//
// 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -
//1 。
//
//
// 示例 1：
//
//
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
//
//
// 示例 2：
//
//
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1,0,1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
//
//
// 示例 3：
//
//
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1,2,-1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
//
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 2 * 10⁴
// intervals[i].length == 2
// -10⁶ <= starti <= endi <= 10⁶
// 每个间隔的起点都 不相同
//
// Related Topics 数组 二分查找 排序 👍 194 👎 0
public class FindRightInterval {

    public static void main(String[] args) {
        FindRightInterval fri = new FindRightInterval();
        System.out.println(Arrays.toString(fri.findRightInterval2(new int[][]{{1,4},{2,3},{3,4}})));
    }

    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = intervals.length;

        for (int i = 0;i < n; i++){
            treeMap.put(intervals[i][0],i);
        }
        int[] arr = new int[n];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
            arr[index++] = entry.getKey();
        }
        int[] ans = new int[n];
        for (int i = 0; i < n;i++){
            int target = intervals[i][1];
            int l = -1;
            int r = n;
            while (l +1 != r){
                int mid = l + (r - l)/2;
                if (arr[mid] >= target){
                    r = mid;
                }else {
                    l = mid;
                }
            }
            if (r == n || arr[r] < target){
                ans[i] = -1;
            }else {
                ans[i] = treeMap.get(arr[r]);
            }

        }
        return ans;
    }

    /**
     * 不用treeMap
     * @param intervals
     * @return
     */
    public int[] findRightInterval2(int[][] intervals) {

        int n = intervals.length;
        int[][] arr = new int[n][3];
        for (int i = 0;i < n; i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = i;
        }
        int[] ans = new int[n];
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n;i++){
            int target = intervals[i][1];
            int l = -1;
            int r = n;
            while (l +1 != r){
                int mid = l + (r - l)/2;
                if (arr[mid][0] >= target){
                    r = mid;
                }else {
                    l = mid;
                }
            }
            if (r == n){
                ans[i] = -1;
            }else {
                ans[i] = arr[r][2];
            }

        }
        return ans;
    }

}
