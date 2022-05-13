package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengj
 * @Description 94.二叉树的中序遍历 简单
 * @Date 2022/3/3
 */

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1288 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doTraversal(root,ans);
        return ans;
    }
    
    private void doTraversal(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        doTraversal(root.left,ans);
        ans.add(root.val);
        doTraversal(root.right,ans);
    }

    /**
     * 非递归的方式
     * @param root
     */
    private List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            }else {
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
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
