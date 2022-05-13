package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengj
 * @Description 515.在每个树行中找最大值 中等
 * @Date 2022/3/4
 */
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 169 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0;i < size;i++){
                TreeNode curr = queue.poll();
                max = Math.max(curr.val,max);
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }

            }
            ans.add(max);
        }
        return ans;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
