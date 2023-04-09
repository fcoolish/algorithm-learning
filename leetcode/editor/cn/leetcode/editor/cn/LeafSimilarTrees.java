//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,
//null,null,null,null,9,8]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,2,3], root2 = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定的两棵树结点数在 [1, 200] 范围内 
// 给定的两棵树上的值在 [0, 200] 范围内 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 203 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class LeafSimilarTrees{
    public static void main(String[] args){
        Solution solution = new LeafSimilarTrees().new Solution();
        TreeNode root1 = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root1.left = l1;
        root1.right = r1;
        TreeNode root2 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        root2.left = l2;
        root2.right = r2;
        solution.leafSimilar(root1,root2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        String s1 = getTreeStr(root1);
        String s2 = getTreeStr(root2);
        return s1.equals(s2);
    }


    public String getTreeStr(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null){
                s.append(node.val);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right !=null){
                stack.push(node.right);
            }
        }
        return s.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}