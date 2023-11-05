//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1018 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreePostorderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        TreeNode node = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        node.right = n2;
        n2.left = n3;
        solution.postorderTraversal(node);
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

    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null)return list;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.removeFirst();
            list.addFirst(node.val);
            if(node.left != null){
                stack.addFirst(node.left);
            }
            if(node.right != null){
                stack.addFirst(node.right);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left != null || node.right != null){
                if(node.right != null){
                    stack.push(node.right);
                    node.right = null;
                }
                if(node.left != null){
                    stack.push(node.left);
                    node.left = null;
                }
            }else{
                list.add(node.val);
                stack.pop();
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node,List<Integer> res){
        if(node == null)return;
        dfs(node.left,res);
        dfs(node.right,res);
        res.add(node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}