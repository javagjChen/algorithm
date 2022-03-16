package back;

import com.sun.xml.internal.ws.api.server.LazyMOMProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengj
 * @Description 组合总和3 中等
 * @Date 2022/3/15
 */
//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
//
// 只使用数字1到9
// 每个数字 最多使用一次
//
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
//
//
//
// 示例 1:
//
//
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。
//
// 示例 2:
//
//
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。
//
// 示例 3:
//
//
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
//
//
//
//
// 提示:
//
//
// 2 <= k <= 9
// 1 <= n <= 60
//
// Related Topics 数组 回溯 👍 433 👎 0
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3,9).toString());
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        doCombinationSum(ans,list,k,n,1,0);
        return ans;
    }

    private void doCombinationSum(List<List<Integer>> ans, List<Integer> list,
                                  int k, int target, int index,int sum) {
        if (list.size() == k && target == sum){
            List<Integer> tmp = new ArrayList<>(list);
            ans.add(tmp);
            return;
        }
        if (list.size() > k || sum > target){
            return;
        }
        for (int i = index;i <= 9;i++){
            list.add(i);
            sum += i;
            doCombinationSum(ans,list,k,target,i + 1,sum);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
