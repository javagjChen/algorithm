package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengj
 * @Description 105.从前序与中序遍历序列构造二叉树 中等
 * @Date 2022/3/9
 */
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。
//
//
//
// 示例 1:
//
//
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均 无重复 元素
// inorder 均出现在 preorder
// preorder 保证 为二叉树的前序遍历序列
// inorder 保证 为二叉树的中序遍历序列
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1466 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class BuildTreeByInAndPre {

    int postIndex = 0;
    private int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int index = 0;
        for (Integer integer : inorder){
            map.put(integer,index++);
        }
        return doBuildTree(0,preorder.length - 1);
    }

    private TreeNode doBuildTree(int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex){
            return null;
        }
        int rootVal = preorder[postIndex++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        //这里一定是先构建左子树的
        root.left = doBuildTree(leftIndex,rootIndex - 1);
        root.right = doBuildTree(rootIndex + 1,rightIndex);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
