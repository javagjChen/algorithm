package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description 114.二叉树展开为链表
 * @Date 2022/5/13
 */
public class Flatten {

    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root,queue);
        if(queue.isEmpty()){
            return;
        }
        root = queue.poll();
        root.left = null;
        while(!queue.isEmpty()){
            root.right = queue.poll();
            root = root.right;
            root.left = null;
        }
        return;
    }

    private void preOrder(TreeNode root,Queue<TreeNode> queue){
        if(root == null){
            return;
        }
        queue.add(root);
        preOrder(root.left,queue);

        preOrder(root.right,queue);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
