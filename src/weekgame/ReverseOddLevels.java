package weekgame;

import java.util.*;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/18
 */
public class ReverseOddLevels {
    public static void main(String[] args) {
        ReverseOddLevels rol = new ReverseOddLevels();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);
        System.out.println(rol.reverseOddLevels(root));
    }

    /**
     * 只换值，其他不改变
     * @param root
     * @return
     */
    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            if (index % 2 == 1){
                Queue<TreeNode> tmp = new LinkedList<>();
                for (int i = 0;i < size;i++){
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    tmp.add(node);
                }
                int i = size -1;
                while (!tmp.isEmpty()){
                    TreeNode poll = tmp.poll();
                    poll.val = list.get(i--);
                    queue.add(poll);
                }
                list.clear();

            }
            for (int i = 0;i <size;i++){

                TreeNode node = queue.poll();

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }


            }
            index++;
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
