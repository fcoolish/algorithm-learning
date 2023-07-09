//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 582 👎 0

package leetcode.editor.cn;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        TreeNode node = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        node.left = node2;
        node.right = node3;
        //solution.widthOfBinaryTree(node);
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

        public int widthOfBinaryTree(TreeNode root){
            if(root == null)return 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            Map<TreeNode,Integer> map = new HashMap<>();
            map.put(root,1);
            int ans = 0;
            while (!queue.isEmpty()){
                int start = map.get(queue.peek());
                int size = queue.size();
                while (size > 0){
                    TreeNode cur = queue.poll();
                    size--;
                    int index = map.get(cur);
                    if(cur.left != null){
                        queue.offer(cur.left);
                        map.put(cur.left,2 * index);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                        map.put(cur.right,2 * index + 1);
                    }
                    if(size == 0){
                        ans = Math.max(ans,index - start + 1);
                    }
                }
            }
            return ans;
        }

        //超时
        public int widthOfBinaryTree1(TreeNode root) {
            if (root == null) return 0;
            int ans = 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int l = -1, r = -1;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.val != -101) {
                        if (l == -1) {
                            l = i;
                            r = i;
                        } else {
                            r = i;
                        }
                        ans = Math.max(r - l + 1, ans);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    } else {
                        TreeNode nn = new TreeNode(-101);
                        queue.offer(nn);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    } else {
                        TreeNode nn = new TreeNode(-101);
                        queue.offer(nn);
                    }
                }
                if (l == -1 && r == -1) {
                    return ans;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}