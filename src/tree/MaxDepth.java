package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengj
 * @Description 二叉树的最大深度 简单
 * @Date 2022/3/4
 */
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1132 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode curr = queue.poll();
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
            ans++;
        }
        return ans;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth2(root.left),maxDepth2(root.right)) + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
