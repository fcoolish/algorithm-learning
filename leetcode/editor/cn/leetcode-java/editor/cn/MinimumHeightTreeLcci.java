//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3 
//  9        /   /      -10  5 Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 137 👎 0

package leetcode.editor.cn;
public class MinimumHeightTreeLcci{
    public static void main(String[] args){
        Solution solution = new MinimumHeightTreeLcci().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length - 1);
    }

    private TreeNode buildTree(int[] nums,int left,int right){
        if(left >  right)return null;
        int mid = (right - left)/2 + left;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = buildTree(nums,left,mid - 1);
        treeNode.right = buildTree(nums,mid + 1,right);
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}