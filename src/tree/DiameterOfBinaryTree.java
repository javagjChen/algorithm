package tree;

/**
 * @author chengj
 * @Description 543.二叉树的直径 简单
 * @Date 2022/8/5
 */
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树 深度优先搜索 二叉树 👍 1116 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class DiameterOfBinaryTree {

    public int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return max;
    }

    public int getDiameter(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = getDiameter(node.left);
        int right = getDiameter(node.right);
        if(max < (left + right)){
            max = left + right;
        }

        return Math.max(left,right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
