package partice;

import java.util.Arrays;

/**
 * @author chengj
 * @Description 1090.受标签影响的最大值 中等
 * @Date 2022/9/13
 */
//我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还
//会给出两个整数 numWanted 和 useLimit 。
//
// 从 n 个元素中选择一个子集 s :
//
//
// 子集 s 的大小 小于或等于 numWanted 。
// s 中 最多 有相同标签的 useLimit 项。
//
//
// 一个子集的 分数 是该子集的值之和。
//
// 返回子集 s 的最大 分数 。
//
//
//
// 示例 1：
//
//
//输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
//输出：9
//解释：选出的子集是第一项，第三项和第五项。
//
//
// 示例 2：
//
//
//输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
//输出：12
//解释：选出的子集是第一项，第二项和第三项。
//
//
// 示例 3：
//
//
//输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
//输出：16
//解释：选出的子集是第一项和第四项。
//
//
//
//
// 提示：
//
//
// n == values.length == labels.length
// 1 <= n <= 2 * 10⁴
// 0 <= values[i], labels[i] <= 2 * 10⁴
// 1 <= numWanted, useLimit <= n
//
// Related Topics 贪心 数组 哈希表 计数 排序 👍 27 👎 0
public class LargestValsFromLabels {



    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        // 辅助数组 存储 值和标签
        int[][] helper = new int[n][2];

        for (int i = 0;i < n;i++){
            helper[i][0] = values[i];
            helper[i][1] = labels[i];
        }
        // 值由大到小排序
        Arrays.sort(helper,((o1, o2) -> o2[0] - o1[0]));
        // 用来统计每个标签出现的次数
        int[] count = new int[20001];
        int sum = 0;
        int index = 0;
        for (int i = 0;i < n;i++){
            if( index < numWanted && count[helper[i][1]] < useLimit){
                sum += helper[i][0];
                index++;
                count[helper[i][1]]++;
            }
        }
        return sum;

    }
}
