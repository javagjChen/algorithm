package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 112.路径总和 简单
 * @Date 2022/3/8
 */
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。
//
// 叶子节点 是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
//
//
// 示例 2：
//
//
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。
//
// 示例 3：
//
//
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 803 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return false;
        }
        getPath(root,list,ans);

        for (List<Integer> tmp : ans){
            int sum = 0;
            for (Integer a : tmp){
                sum += a;
            }
            if (sum == targetSum){
                return true;
            }
        }
        return false;
    }

    // 先找到所有的路径和
    private void getPath(TreeNode node, List<Integer> list, List<List<Integer>> ans) {

        list.add(node.val);
        if (node.left == null && node.right == null){
            ans.add(new ArrayList<>(list));
            return;
        }

        if (node.left != null){
            getPath(node.left,list,ans);
            list.remove(list.size() -1);
        }
        if (node.right != null){
            getPath(node.right,list,ans);
            list.remove(list.size() -1);
        }
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum2(root.left,targetSum - root.val) || hasPathSum2(root.right,targetSum - root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
