package tree;

/**
 * @author chengj
 * @Description 226.翻转二叉树 简单
 * @Date 2022/3/4
 */
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
//输入：root = [2,1,3]
//输出：[2,3,1]
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
// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1284 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        doInvertTree(root);
        return root;
    }
    public void doInvertTree(TreeNode node){
        if (node == null){
            return;
        }
        TreeNode tmpNode = node.left;
        node.left = node.right;
        node.right = tmpNode;
        doInvertTree(node.left);
        doInvertTree(node.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
