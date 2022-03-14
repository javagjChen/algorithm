package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 二叉搜索树中的众数 简单
 * @Date 2022/3/13
 */
//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 419 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class FindMode {

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        if (list.size() ==1){
            return new int[]{list.get(0)};
        }
        int base = Integer.MIN_VALUE;
        int count = 1;
        List<Integer> ans = new ArrayList<>();
        int maxCount = 0;
        for (int i = 0;i < list.size();i++){
            int tmp = list.get(i);
            if (tmp == base){
                count++;
            }else {
                base = tmp;
                count = 1;
            }
            if (count == maxCount){
                ans.add(tmp);
            }
            if (count > maxCount){
                ans.clear();
                ans.add(tmp);
                maxCount = count;
            }
        }
        int [] result = new int[ans.size()];
        for (int i =0;i < ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
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
