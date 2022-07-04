package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author chengj
 * @Description 1488.避免洪水泛滥 中等
 * @Date 2022/7/1
 */
//你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，那么它就会装满水。如果第 n 个湖泊下雨前是 满的 ，这个湖泊会发生 洪水 。你
//的目标是避免任意一个湖泊发生洪水。
//
// 给你一个整数数组 rains ，其中：
//
//
// rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
// rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
//
//
// 请返回一个数组 ans ，满足：
//
//
// ans.length == rains.length
// 如果 rains[i] > 0 ，那么ans[i] == -1 。
// 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
//
//
// 如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
//
// 请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。
//
//
//
// 示例 1：
//
//
//输入：rains = [1,2,3,4]
//输出：[-1,-1,-1,-1]
//解释：第一天后，装满水的湖泊包括 [1]
//第二天后，装满水的湖泊包括 [1,2]
//第三天后，装满水的湖泊包括 [1,2,3]
//第四天后，装满水的湖泊包括 [1,2,3,4]
//没有哪一天你可以抽干任何湖泊的水，也没有湖泊会发生洪水。
//
//
// 示例 2：
//
//
//输入：rains = [1,2,0,0,2,1]
//输出：[-1,-1,2,1,-1,-1]
//解释：第一天后，装满水的湖泊包括 [1]
//第二天后，装满水的湖泊包括 [1,2]
//第三天后，我们抽干湖泊 2 。所以剩下装满水的湖泊包括 [1]
//第四天后，我们抽干湖泊 1 。所以暂时没有装满水的湖泊了。
//第五天后，装满水的湖泊包括 [2]。
//第六天后，装满水的湖泊包括 [1,2]。
//可以看出，这个方案下不会有洪水发生。同时， [-1,-1,1,2,-1,-1] 也是另一个可行的没有洪水的方案。
//
//
// 示例 3：
//
//
//输入：rains = [1,2,0,1,2]
//输出：[]
//解释：第二天后，装满水的湖泊包括 [1,2]。我们可以在第三天抽干一个湖泊的水。
//但第三天后，湖泊 1 和 2 都会再次下雨，所以不管我们第三天抽干哪个湖泊的水，另一个湖泊都会发生洪水。
//
//
//
//
// 提示：
//
//
// 1 <= rains.length <= 10⁵
// 0 <= rains[i] <= 10⁹
//
// Related Topics 贪心 数组 哈希表 二分查找 堆（优先队列） 👍 96 👎 0
public class AvoidFlood {


    // 看不到哪里体现了二分
    /**
     * 1、将晴天的日期全部记录到 set<int> zero 中
     * 2、使用 unordered_map<int, int> water 来记录每个湖泊上一次下雨的日期
     * 3、遇到晴天时先不用管抽哪个湖
     * 4、当下雨时，湖泊已经水满了时，我们可以查询到上次下雨的日期
     * 5、通过这个日期在晴天记录中查找对应的晴天日期
     *    5.1、 在有序数据中查找，用二分啦
     * 6、如果找到了，就可以使用那一天抽水，找不到就不可避免的洪水了
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        Map<Integer, Integer> water = new HashMap<>();
        TreeSet<Integer> zero = new TreeSet<>();
        for(int i = 0; i < rains.length; ++i){
            int rain = rains[i];
            if(rain == 0){//晴天，存下标
                zero.add(i);
                continue;
            }
            if(water.containsKey(rain)){//下雨天，且这个湖泊已经下过雨了
                Integer r = zero.higher(water.get(rain));//找到之前一次下雨的下标所对应的下一个晴天下标
                if(r == null) {
                    return new int[]{};//如果没有满足要求的晴天下标，返回空数组
                }
                ans[r] = rain;//清空的湖泊下标
                zero.remove(r);//移除已经使用过的晴天
            }
            water.put(rain, i);//存放下雨的湖泊
            ans[i] = -1;//下雨不能操作
        }
        return ans;
    }
}
