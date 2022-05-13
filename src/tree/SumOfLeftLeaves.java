package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description 404.左叶子之和 简单
 * @Date 2022/3/8
 */
//给定二叉树的根节点 root ，返回所有左叶子之和。
//
//
//
// 示例 1：
//
//
//
//
//输入: root = [3,9,20,null,null,15,7]
//输出: 24
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// 示例 2:
//
//
//输入: root = [1]
//输出: 0
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 1000] 范围内
// -1000 <= Node.val <= 1000
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 408 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        int left = inOrder(root.left,true);
        int right = inOrder(root.right,false);
        return sum + left + right;
    }

    private int inOrder(TreeNode node,boolean flag){
        int sum = 0;
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null && flag){
            sum += node.val;
        }
        int left = inOrder(node.left,true);
        int right = inOrder(node.right,false);
        return sum + left + right;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
