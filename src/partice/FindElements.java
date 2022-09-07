package partice;

import tree.AverageOfLevels;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/1
 */
public class FindElements {

    public Set<Integer> set;
    public FindElements(TreeNode root) {
        this.set = new HashSet<>();
        root.val = 0;
        set.add(0);
        dfs(root,0);

    }

    private void dfs(TreeNode root, int val) {
        if (root.left != null){
            root.left.val = 2 * val + 1;
            set.add(2 * val + 1);
            dfs(root.left,2 * val + 1);
        }
        if (root.right != null){
            root.right.val = 2 * val + 2;
            set.add(2 * val + 2);
            dfs(root.right,2 * val + 2);
        }
    }

    public boolean find(int target) {
        return set.contains(target);

    }

    public boolean preOrder(TreeNode node,int target){
        if (node == null){
            return false;
        }
        if (node.val == target){
            return true;
        }
        return preOrder(node.left,target) || preOrder(node.right,target);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
