package weekgame;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 6133. 分组的最大数量
 * @Date 2022/7/31
 */
//给你一个正整数数组 grades ，表示大学中一些学生的成绩。你打算将 所有 学生分为一些 有序 的非空分组，其中分组间的顺序满足以下全部条件：
//
//
// 第 i 个分组中的学生总成绩 小于 第 (i + 1) 个分组中的学生总成绩，对所有组均成立（除了最后一组）。
// 第 i 个分组中的学生总数 小于 第 (i + 1) 个分组中的学生总数，对所有组均成立（除了最后一组）。
//
//
// 返回可以形成的 最大 组数。
//
//
//
// 示例 1：
//
// 输入：grades = [10,6,12,7,3,5]
//输出：3
//解释：下面是形成 3 个分组的一种可行方法：
//- 第 1 个分组的学生成绩为 grades = [12] ，总成绩：12 ，学生数：1
//- 第 2 个分组的学生成绩为 grades = [6,7] ，总成绩：6 + 7 = 13 ，学生数：2
//- 第 3 个分组的学生成绩为 grades = [10,3,5] ，总成绩：10 + 3 + 5 = 18 ，学生数：3
//可以证明无法形成超过 3 个分组。
//
//
// 示例 2：
//
// 输入：grades = [8,8]
//输出：1
//解释：只能形成 1 个分组，因为如果要形成 2 个分组的话，会导致每个分组中的学生数目相等。
//
//
//
//
// 提示：
//
//
// 1 <= grades.length <= 10⁵
// 1 <= grades[i] <= 10⁵
//
// 👍 12 👎 0
public class MaximumGroups {

    public static void main(String[] args) {
        MaximumGroups mg = new MaximumGroups();
        int[] grades = new int[]{5,2,5,39,4,28,9,41,1,4,23,45,46,37,4,17,28,6,29,39};
        System.out.println(mg.maximumGroups(grades));
    }

    public int maximumGroups(int[] grades) {
        int n = grades.length;
        if (n <=2){
            return 1;
        }

        int pre = 0;

        for (int i = 1;i < n;i++){
            pre += i;

            if (pre >= n || pre + (i+1) > n){
                return i ;
            }
        }
        return 1;
    }
}
