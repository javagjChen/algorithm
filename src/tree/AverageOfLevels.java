package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengj
 * @Description 637.二叉树的层平均值 简单
 * @Date 2022/3/4
 */
//给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树中节点数量在 [1, 10⁴] 范围内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 313 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0;i < size;i++){
                TreeNode curr = queue.poll();
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
                sum += curr.val;
            }
            result.add(sum/size);
        }
        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
