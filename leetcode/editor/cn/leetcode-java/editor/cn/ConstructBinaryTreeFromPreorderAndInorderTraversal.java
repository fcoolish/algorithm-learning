//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1946 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args){
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

    private Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i =0;i < n;i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,inorder,0,n - 1,0,n - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int pL,int pR,int iL,int iR){
        if(pL > pR)return null;
        int rootIndex = map.get(preorder[pL]);
        int size = rootIndex - iL;
        TreeNode root = new TreeNode(preorder[pL]);
        root.left = buildTreeHelper(preorder,inorder,pL + 1,pL + size,iL,rootIndex - 1);
        root.right = buildTreeHelper(preorder,inorder,pL + size  + 1,pR,rootIndex + 1,iR);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}