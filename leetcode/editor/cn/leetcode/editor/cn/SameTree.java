//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
// 
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1000 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree{
    public static void main(String[] args){
        Solution solution = new SameTree().new Solution();
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode n1 = queue1.poll();
            TreeNode n2 = queue2.poll();
            if(n1.val != n2.val){
                return false;
            }
            TreeNode l1 = n1.left,l2 = n2.left,r1 = n1.right,r2 = n2.right;
            if(l1 == null ^ l2 == null){
                return false;
            }
            if(r1 == null ^ r2 == null){
                return false;
            }
            if(l1 != null){
                queue1.offer(l1);
            }
            if(r1 != null){
                queue1.offer(r1);
            }
            if(l2 != null){
                queue2.offer(l2);
            }
            if(r2 != null){
                queue2.offer(r2);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}