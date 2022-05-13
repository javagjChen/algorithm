package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author chengj
 * @Description 111.二叉树的最小深度 简单
 * @Date 2022/3/4
 */
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 681 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class MinDepth {


    public int minDepth(TreeNode root) {
        if (root ==null){
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for (int i = 0;i < size;i++){
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null){
                    return ans;
                }
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
