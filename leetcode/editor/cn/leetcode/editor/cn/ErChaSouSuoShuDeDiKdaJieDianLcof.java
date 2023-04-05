//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 378 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode node = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(1);
        node.left = n1;
        node.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n5;
        solution.kthLargest(node,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int kk = 0,res = 0;
    public int kthLargest(TreeNode root, int k) {
        kk = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node){
        if(node == null || kk == 0) return;
        dfs(node.right);
        kk--;
        if(kk == 0){
            res = node.val;
            return;
        }
        dfs(node.left);
    }

    public int kthLargest1(TreeNode root, int k) {
        TreeSet<Integer> q = new TreeSet<>((o1, o2) -> o2-o1);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            q.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        for(int i =0;i < k - 1;i++){
            q.pollFirst();
        }
        return q.first();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}