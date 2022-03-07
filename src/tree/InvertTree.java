package tree;

/**
 * @author chengj
 * @Description
 * @Date 2022/3/4
 */
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
