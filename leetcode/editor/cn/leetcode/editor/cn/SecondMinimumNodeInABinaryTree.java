//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。 
//
// 如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 2³¹ - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 291 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SecondMinimumNodeInABinaryTree{
    public static void main(String[] args){
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
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
    int val = 0;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)return -1;
        val = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null)return;
        if(ans != -1 && root.val >= ans){
            return;
        }
        if(root.val > val){
            ans = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue1(TreeNode root) {
        if(root == null)return -1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!priorityQueue.contains(node.val)){
                priorityQueue.add(node.val);
            }
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        if(priorityQueue.size() < 2){
            return -1;
        }
        priorityQueue.poll();
        return priorityQueue.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}