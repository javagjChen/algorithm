package weekgame;

import tree.BinaryTreePaths;

/**
 * @author chengj
 * @Description
 * @Date 2022/7/9
 */
public class EvaluateTree {

    public boolean evaluateTree(TreeNode root) {

        return doEvaluate(root);

    }

    public boolean doEvaluate(TreeNode node){
        if (node.left == null || node.right == null){
            return node.val == 0 ? false : true;
        }
        boolean left = doEvaluate(node.left);
        boolean right = doEvaluate(node.right);

        return node.val == 2 ? left | right : left & right;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
