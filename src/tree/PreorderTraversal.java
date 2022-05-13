package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengj
 * @Description 144.二叉树的前序遍历 简单
 * @Date 2022/3/3
 */
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 742 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class PreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doTraversal(root,ans);
        return ans;
    }

    private void doTraversal(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        ans.add(root.val);
        doTraversal(root.left,ans);
        doTraversal(root.right,ans);
    }

    /**
     * 非递归的方式
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
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
