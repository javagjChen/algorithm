package binarysearch;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chengj
 * @Description 826.安排工作以达到最大收益
 * @Date 2022/6/24
 */
//你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
//
//
// difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
// worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
//
//
// 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
//
//
// 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
//
//
// 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
//
//
//
// 示例 1：
//
//
//输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//输出: 100
//解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
//
// 示例 2:
//
//
//输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
//输出: 0
//
//
//
// 提示:
//
//
// n == difficulty.length
// n == profit.length
// m == worker.length
// 1 <= n, m <= 10⁴
// 1 <= difficulty[i], profit[i], worker[i] <= 10⁵
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 88 👎 0
public class MaxProfitAssignment {

    /**
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Point[] jobs = new Point[N];
        for (int i = 0; i < N; ++i) {
            jobs[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.x));
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < N && skill >= jobs[i].x){
                best = Math.max(best, jobs[i++].y);
            }

            ans += best;
        }

        return ans;
    }


    /**
     * 蓝红二分
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Point[] jobs = new Point[n];
        for (int i = 0; i < n; ++i)
            jobs[i] = new Point(difficulty[i], profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.x));
        int maxProfit = 0;
        for (int i=0; i<n; ++i) {
            jobs[i].y = Math.max(maxProfit, jobs[i].y);
            maxProfit = jobs[i].y;
        }

        Arrays.sort(worker);

        int ans = 0;
        int best = 0;
        for (int i=0; i<worker.length; ++i) {
            int l = -1, r = n;
            while (l+1 != r) {
                int mid = (l+r)>>1;
                if (jobs[mid].x <= worker[i]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (l != -1) {
                best = Math.max(best, jobs[l].y);
                ans += best;
            }
        }
        return ans;

    }
}
