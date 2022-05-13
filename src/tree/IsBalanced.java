package tree;

/**
 * @author chengj
 * @Description 110.平衡二叉树 简单
 * @Date 2022/3/7
 */
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -10⁴ <= Node.val <= 10⁴
//
// Related Topics 树 深度优先搜索 二叉树 👍 910 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class IsBalanced {
    
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null){
            return 0;
        }
        int left = height(node.left);
        if (left == -1){
            return -1;
        }
        int right = height(node.right);
        if (right == -1){
            return -1;
        }
        return Math.abs(left - right) > 2 ? -1:Math.max(left,right) + 1;
    }

    public boolean ans = true;
    public boolean isBalanced2(TreeNode root) {
        getHeight(root);
        return ans;
    }

    private int getHeight(TreeNode node) {
        if (node == null){
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (Math.abs(left-right) >1){
            ans = false;
        }
        return Math.max(left,right) + 1;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
