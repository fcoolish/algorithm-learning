//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 815 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        node2.right = node4;
        solution.binaryTreePaths(node);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            if(root == null)return ans;
            Stack<TreeNode> stack = new Stack<>();
            Stack<String> sPath = new Stack<>();
            stack.push(root);
            sPath.push(Integer.toString(root.val));
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                String path = sPath.pop();
                if(node.left == null && node.right == null){
                    ans.add(path.toString());
                }else{
                    if(node.right != null){
                        stack.push(node.right);
                        sPath.push(new StringBuilder(path).append("->").append(node.right.val).toString());
                    }
                    if(node.left != null){
                        stack.push(node.left);
                        sPath.push(new StringBuilder(path).append("->").append(node.left.val).toString());
                    }
                }
            }
            return ans;
        }

        public List<String> binaryTreePaths1(TreeNode root) {
            List<String> ans = new ArrayList<>();
            getPath(root, new StringBuilder(), ans);
            return ans;
        }

        public void getPath(TreeNode node,StringBuilder str,List<String> res){
            if(node == null){
                return;
            }
            StringBuilder ppth = new StringBuilder(str);
            if(str.length() != 0){
                ppth.append("->");
            }
            ppth.append(node.val);
            if(node.left == null && node.right == null){
                res.add(ppth.toString());
            }else{
                getPath(node.left,ppth,res);
                getPath(node.right,ppth,res);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}