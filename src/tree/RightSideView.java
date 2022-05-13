package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengj
 * @Description 199.二叉树的右视图 中等
 * @Date 2022/3/4
 */
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//
//
// 示例 1:
//
//
//
//
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
//
//
// 示例 2:
//
//
//输入: [1,null,3]
//输出: [1,3]
//
//
// 示例 3:
//
//
//输入: []
//输出: []
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,100]
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 679 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class RightSideView {

    public List<Integer> levelOrderBottom(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
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
                if (i == size -1){
                    result.add(curr.val);
                }
            }
        }
        return result;
    }

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
