package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengj
 * @Description 919. 完全二叉树插入器 中等
 * @Date 2022/7/25
 */
//完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
//
// 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
//
// 实现 CBTInserter 类:
//
//
// CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
// CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态
//，并返回插入节点 TreeNode 的父节点的值；
// CBTInserter.get_root() 将返回树的头节点。
//
//
//
//
//
//
//
// 示例 1：
//
//
//
//
//输入
//["CBTInserter", "insert", "insert", "get_root"]
//[[[1, 2]], [3], [4], []]
//输出
//[null, 1, 2, [1, 2, 3, 4]]
//
//解释
//CBTInserter cBTInserter = new CBTInserter([1, 2]);
//cBTInserter.insert(3);  // 返回 1
//cBTInserter.insert(4);  // 返回 2
//cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
//
//
//
// 提示：
//
//
// 树中节点数量范围为 [1, 1000]
// 0 <= Node.val <= 5000
// root 是完全二叉树
// 0 <= val <= 5000
// 每个测试用例最多调用 insert 和 get_root 操作 10⁴ 次
//
// Related Topics 树 广度优先搜索 设计 二叉树 👍 123 👎 0
public class CBTInserter {

    TreeNode root;
    Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new ArrayDeque<>();
        //采用层序遍历 找到没有叶子结点的结点存放到队列中
        //只有这些结点才可以添加结点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //顺序存储没有叶子结点的结点
            if (node.left == null || node.right == null) {
                deque.offer(node);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        //该结点如果一个叶子结点都没有 插入左结点
        if (node.left == null) {
            node.left = deque.peekLast();
        } else {
            //有左结点、插入右结点并删除该结点
            node.right = deque.peekLast();
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
