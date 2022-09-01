package partice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengj
 * @Description 988. 从叶结点开始的最小字符串 中等
 * @Date 2022/8/29
 */
//给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
//
// 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
//
//
// 注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
//
//
// 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
//
//
//
// 节点的叶节点是没有子节点的节点。
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
//输入：root = [0,1,2,3,4,3,4]
//输出："dba"
//
//
// 示例 2：
//
//
//
//
//输入：root = [25,1,3,1,3,0,2]
//输出："adz"
//
//
// 示例 3：
//
//
//
//
//输入：root = [2,2,1,null,1,0,null,0]
//输出："abc"
//
//
//
//
// 提示：
//
//
// 给定树的结点数在 [1, 8500] 范围内
// 0 <= Node.val <= 25
//
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 88 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class SmallestFromLeaf {

    public static void main(String[] args) {

        TreeNode bb = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        TreeNode b = new TreeNode(1,bb,d);

        TreeNode a = new TreeNode(0);
        TreeNode c = new TreeNode(2);
        TreeNode dr = new TreeNode(3,a,c);

        TreeNode z = new TreeNode(25,b,dr);
        SmallestFromLeaf sfl = new SmallestFromLeaf();
        System.out.println(sfl.smallestFromLeaf(z));

    }
    public String smallestFromLeaf(TreeNode root) {
        List<Character> list = new ArrayList<>();
        List<List<Character>> ans = new ArrayList<>();
        dps(root,ans,list);
        List<Character> first = ans.get(0);
        StringBuilder f = new StringBuilder();
        for (Character ch : first){
            f.append(ch);
        }
        String base = f.reverse().toString();
        for (List<Character> item : ans){
            StringBuilder sb = new StringBuilder();
            for (Character ch : item){
                sb.append(ch);
            }
            if (sb.reverse().toString().compareTo(base) < 0){
                base = sb.toString();
            }
        }
        return base;
    }

    public void dps(TreeNode root, List<List<Character>> ans, List<Character> list) {
        list.add((char) ('a' + root.val));

        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null){
            dps(root.left,ans,list);
            list.remove(list.size() - 1);
        }

        if (root.right != null){
            dps(root.right,ans,list);
            list.remove(list.size() - 1);
        }

    }


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }
        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
