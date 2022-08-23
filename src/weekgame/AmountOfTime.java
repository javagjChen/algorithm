package weekgame;

/**
 * @author chengj
 * @Description 2385.感染二叉树需要的总时间 中等
 * @Date 2022/8/21
 */
//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。
//
// 每分钟，如果节点满足以下全部条件，就会被感染：
//
//
// 节点此前还没有感染。
// 节点与一个已感染节点相邻。
//
//
// 返回感染整棵树需要的分钟数。
//
//
//
// 示例 1：
//
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
//
//
// 示例 2：
//
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 10⁵] 内
// 1 <= Node.val <= 10⁵
// 每个节点的值 互不相同
// 树中必定存在值为 start 的节点
//
// 👍 12 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class AmountOfTime {

    int ans = 0;    // 最短用时
    int depth = -1; // 起始节点的高度

    // 这题没有想出来，连思路都不对
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, 0, start);
        return ans;
    }

    int dfs(TreeNode root, int level, int start) {
        if (root == null) return 0;
        if (root.val == start) depth = level;                       // 当前节点即起始节点
        int l = dfs(root.left, level + 1, start);                   // 左子树的树高
        boolean inLeft = depth != -1;                               // 起始节点是否在左子树上
        int r = dfs(root.right, level + 1, start);                  // 右子树的树高
        if (root.val == start) ans = Math.max(ans, Math.max(l, r)); // 情况1：感染以 start 为根结点的树所需时间
        if (inLeft) ans = Math.max(ans, depth - level + r);         // 情况2：感染以 root 为根结点的树所需时间
        else ans = Math.max(ans, depth - level + l);
        return Math.max(l, r) + 1;                                  // 返回树高
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
