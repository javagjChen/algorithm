package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 二叉树的所有路径 简单
 * @Date 2022/3/7
 */
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 669 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        List<String> path = new ArrayList<>();
        getLeave(root,path,ans);
        return ans;
    }

    private void getLeave(TreeNode node,List<String> path,List<String> ans){
        path.add(String.valueOf(node.val));
        // 终止条件
        if (node.left == null && node.right == null){
            ans.add(String.join("->",path));
            return;
        }
        if (node.left != null){
            getLeave(node.left,path,ans);
            path.remove(path.size() -1);
        }
        if (node.right != null){
            getLeave(node.right,path,ans);
            path.remove(path.size() -1);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
