//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 441 👎 0

package leetcode.editor.cn;

import java.util.*;

public class MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args){
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        solution.getMinimumDifference(n1);
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
    int ans = 100001,pre = -1;
    public int getMinimumDifference(TreeNode root){
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root == null)return;
        dfs(root.left);
        if(pre == -1){
            pre = root.val;
        }else{
            ans = Math.min(ans,root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public int getMinimumDifference1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        Collections.sort(list,(a,b) -> a - b);
        int res = 100001;
        for(int i =0;i < list.size() - 1;i++){
            res = Math.min(res,Math.abs(list.get(i) - list.get(i + 1)));
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}