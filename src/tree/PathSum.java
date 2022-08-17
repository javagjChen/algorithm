package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 113.路径总和2 中等
 * @Date 2022/3/8
 */
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 686 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return ans;
        }
        getPath(root,list,ans);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> tmp : ans){
            int sum = 0;
            for (Integer a : tmp){
                sum += a;
            }
            if (sum == targetSum){
                result.add(tmp);
            }
        }
        return result;
    }

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
