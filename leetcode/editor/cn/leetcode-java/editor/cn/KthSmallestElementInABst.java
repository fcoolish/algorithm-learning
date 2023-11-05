//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 733 👎 0

package leetcode.editor.cn;
public class KthSmallestElementInABst{
    public static void main(String[] args){
        Solution solution = new KthSmallestElementInABst().new Solution();
        TreeNode node = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        solution.kthSmallest(node,3);
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

    int ans = -1;
    int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)return ans;
        num = k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if(root == null)return;
        if(ans != -1)return;
        dfs(root.left);
        num -=1;
        if(num == 0){
            ans = root.val;
            return;
        }
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}