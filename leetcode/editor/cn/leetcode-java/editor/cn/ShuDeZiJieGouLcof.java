//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 给定的树 A: 
//
// 3 / \ 4 5 / \ 1 2 给定的树 B： 
//
// 4 / 1 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
//
// Related Topics 树 深度优先搜索 二叉树 👍 745 👎 0

package leetcode.editor.cn;

public class ShuDeZiJieGouLcof{
    public static void main(String[] args){
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        int[][] grid = {{3,2,4},{2,1,9},{1,1,7}};
        //solution.maxMoves(grid);
        //solution.circularGameLosers(5,2);
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }else if(A == null || A.val != B.val){
            return false;
        }
        boolean res = dfs(A, B);
        return res || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean dfs(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }else if(A == null || A.val != B.val){
            return false;
        }
        return dfs(A.left,B.left) && dfs(A.right,B.right);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}