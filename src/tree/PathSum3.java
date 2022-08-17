package tree;

/**
 * @author chengj
 * @Description 437.路径总和3 中等
 * @Date 2022/8/12
 */
//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1423 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        long ans = getResult(root,targetSum);
        ans += pathSum(root.left,targetSum);
        ans += pathSum(root.right,targetSum);
        return (int) ans;
    }

    public long getResult(TreeNode node,long target){
        if(node == null){
            return 0;
        }
        long ans = 0;
        if (node.val == target){
            ans++;
        }
        ans += getResult(node.left,target - node.val);
        ans += getResult(node.right,target - node.val);
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
}
