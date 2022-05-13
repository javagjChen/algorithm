package tree;

import java.util.*;

/**
 * @author chengj
 * @Description 102.二叉树的层序遍历 中等
 * @Date 2022/3/3
 */
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1199 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>(size);
            for (int i = 0;i < size;i++){
                TreeNode curr = queue.poll();
                tmp.add(curr.val);
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
            ans.add(tmp);
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
