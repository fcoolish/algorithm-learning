//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1932 👎 0

package leetcode.editor.cn;
public class BinaryTreeMaximumPathSum{
    public static void main(String[] args){
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.left = node2;
        node.right = node3;
        solution.maxPathSum(node);
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

    int ans = -1001;
    public int maxPathSum(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    private int dfs(TreeNode node,int sum){
        if(node == null)return 0;
        int l = Math.max(dfs(node.left,sum),0);
        int r = Math.max(dfs(node.right,sum),0);
        int num = l + r + node.val;
        ans = Math.max(ans,num);
        return node.val + Math.max(l,r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}