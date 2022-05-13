package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description 106.从中序与后序遍历序列构造二叉树 中等
 * @Date 2022/3/9
 */
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 687 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class BuildTreeByInAndPost {

    public static void main(String[] args) {
        BuildTreeByInAndPost buildTreeByInAndPost = new BuildTreeByInAndPost();
        int[] inorde =new int[]{4,2,5,1,6,3,7};
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        System.out.println(buildTreeByInAndPost.buildTree(inorde,postorder));
    }

    int postIndex = 0;
    private int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        postIndex = postorder.length - 1;
        int index = 0;
        for (Integer integer : inorder){
            map.put(integer,index++);
        }
        return doBuildTree(0,postIndex);
    }

    private TreeNode doBuildTree(int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex){
            return null;
        }
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        // 这里一定是先构建右子树的
        root.right = doBuildTree(rootIndex + 1,rightIndex);
        root.left = doBuildTree(leftIndex,rootIndex - 1);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
