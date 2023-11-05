//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1062 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof{
    public static void main(String[] args){
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i =0;i < inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        int n = preorder.length;
        TreeNode root = buildTreeHelper(preorder,inorder,inorderMap,0,n - 1,0,n - 1);
        return root;
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder,Map<Integer,Integer> map,int pl,int pr,int il,int ir){
        if(pl > pr)return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int index = map.get(preorder[pl]);
        int size = index - il;
        root.left = buildTreeHelper(preorder,inorder,map,pl + 1,pl + size,il,index - 1);
        root.right = buildTreeHelper(preorder,inorder,map,pl + size + 1,pr,index + 1,ir);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}