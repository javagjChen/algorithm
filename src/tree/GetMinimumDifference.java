package tree;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 530.二叉搜索树的最小绝对差 简单
 * @Date 2022/3/12
 */
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 313 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        inOrder(root);
        return min;
    }
    int min = 100000;
    int rootVal = -1;
    private void inOrder(TreeNode root) {
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (rootVal != -1) {
            min = Math.min(min, root.val - rootVal);
        }
        rootVal = root.val;
        inOrder(root.right);
    }

    public int getMinimumDifference2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int ans = Integer.MAX_VALUE;
        for (int i = 1;i < list.size();i++){
            ans = Math.min(ans, Math.abs(list.get(i) - list.get(i-1)));
        }
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
