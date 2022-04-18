package weekgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengj
 * @Description 2244. 完成所有任务需要的最少轮数 中等
 * @Date 2022/4/17
 */
//给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任
//务。
//
// 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
//
//
//
// 示例 1：
//
// 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
//输出：4
//解释：要想完成所有任务，一个可能的计划是：
//- 第一轮，完成难度级别为 2 的 3 个任务。
//- 第二轮，完成难度级别为 3 的 2 个任务。
//- 第三轮，完成难度级别为 4 的 3 个任务。
//- 第四轮，完成难度级别为 4 的 2 个任务。
//可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
//
//
// 示例 2：
//
// 输入：tasks = [2,3,3]
//输出：-1
//解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= tasks.length <= 10⁵
// 1 <= tasks[i] <= 10⁹
//
// 👍 9 👎 0
public class MinimumRounds {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : tasks){
            map.put(val,map.getOrDefault(val,0) +1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(entry.getValue());
        }
        int ans = 0;
        for (Integer t : list){
            if (t ==1){
                return -1;
            }
            while (t - 2 >= 0 ){
                if(( t - 3 >1 ) || t - 3 == 0 ){
                    ans++;
                    t = t - 3;
                }else if(t - 2 >= 0){
                    ans++;
                    t = t -2;
                }
            }

        }
        return ans;
    }


    public int minimumRounds2(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : tasks){
            map.put(val,map.getOrDefault(val,0) +1);
        }
        int ans = 0;
        for (Integer t:map.keySet()){
            int mod = t % 3;
            if (mod == 1) {
                t = t - 4;
                ans += 2;
            } else if (mod == 2) {
                t = t - 2;
                ans += 1;
            }
            ans += t / 3;

        }





        return ans;
    }
    public static void main(String[] args) {
        MinimumRounds minimumRounds = new MinimumRounds();
        System.out.println(minimumRounds.minimumRounds(new int[]{66,66,63,61,63,63,64,66,66,65,66,65,61,67,68,66,62,67,61,64,66,
                60,69,66,65,68,63,60,67,62,68,60,66,64,60,60,60,62,66,64,63,65,60,69,63,68,68,69,68,61}));
    }
}
