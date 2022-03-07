package tree;

import java.util.*;

/**
 * @author chengj
 * @Description 对称二叉树 简单
 * @Date 2022/3/7
 */
//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1783 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        return doIsSymmetric(root.left,root.right);
    }

    private boolean doIsSymmetric(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return doIsSymmetric(left.left,right.right) && doIsSymmetric(left.right,right.left);
    }


    public boolean isSymmetric2(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            int size = queue.size();
            if (size %2 != 0){
                return false;
            }
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
