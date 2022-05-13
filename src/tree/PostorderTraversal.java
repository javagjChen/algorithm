package tree;

import java.util.*;

/**
 * @author chengj
 * @Description 145.二叉树的后序遍历 简单
 * @Date 2022/3/3
 */
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 767 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doTraversal(root,ans);
        return ans;
    }

    private void doTraversal(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        doTraversal(root.left,ans);
        doTraversal(root.right,ans);
        ans.add(root.val);
    }

    /**
     * 非递归的方式
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
