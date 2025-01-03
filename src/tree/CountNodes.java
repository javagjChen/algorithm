package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description 222.完全二叉树的节点个数 中等
 * @Date 2022/3/7
 */
//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,4,5,6]
//输出：6
//
//
// 示例 2：
//
//
//输入：root = []
//输出：0
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点的数目范围是[0, 5 * 10⁴]
// 0 <= Node.val <= 5 * 10⁴
// 题目数据保证输入的树是 完全二叉树
//
//
//
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
// Related Topics 树 深度优先搜索 二分查找 二叉树 👍 630 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class CountNodes {

    public int countNodes(TreeNode root) {
        return preOrder(root);
    }

    private int preOrder(TreeNode node){
        if (node == null){
            return 0 ;
        }
        int left = preOrder(node.left);
        int right = preOrder(node.right);
        return left + right + 1;
    }

    //层序遍历也可以
    public int countNodes2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ans += size;
            for (int i =0;i < size;i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }

    /**
     * 二分法
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 最后一层的范围是 2的 level次方 到 2的 level + 1次方-1
        // 所以蓝红二分这样取值
        int l = (1 << level) - 1;
        int r = (1 << (level + 1));
        while (l+1 != r) {
            int mid = l + (r - l)/2;
            if (exists(root, level, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;

    }

    private boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
