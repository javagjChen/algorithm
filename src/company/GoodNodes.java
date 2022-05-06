package company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description
 * @Date 2022/5/6
 */
public class GoodNodes {

    public int goodNodes(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        countGoodNodes(root,ans,root.val);
        return ans.size() + 1;
    }

    private void countGoodNodes(TreeNode root, List<Integer> ans,int pre) {
        if (root == null){
            return;
        }
        if (root.val > pre){
            pre = root.val;
        }
        if (root.left != null && root.left.val >= pre){
            ans.add(root.left.val);
        }
        countGoodNodes(root.left,ans,pre);
        if (root.right != null && root.right.val >= pre){
            ans.add(root.right.val);
        }
        countGoodNodes(root.right,ans,pre);
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
