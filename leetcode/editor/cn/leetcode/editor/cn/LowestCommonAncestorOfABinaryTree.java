//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2257 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args){
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        node.left = node2;
        node.right = node3;
        node2.right = node4;
        solution.lowestCommonAncestor(node,node3,node4);
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


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;
        TreeNode ln = lowestCommonAncestor(root.left,p,q);
        TreeNode rn = lowestCommonAncestor(root.right,p,q);
        if(ln != null && rn !=null){
            return root;
        }else if(ln == null){
            return rn;
        }else if(rn == null){
            return ln;
        }
        return null;
    }

    //以下思路超时
    List<Integer> pList = new ArrayList<>();
    int pi = 0;
    List<Integer> qList =  new ArrayList<>();
    int qi = 0;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q,new ArrayList<>());
        for(int i = qi;i >= 0;i--){
            int index = pList.indexOf(Integer.valueOf(qList.get(i)));
            if(index != -1 && index <= pi){
                return new TreeNode(qList.get(i));
            }
        }
        return null;
    }

    public void dfs(TreeNode root,TreeNode p,TreeNode q,List<Integer> list){
        if(root == null)return;
        if(qList.size() != 0 && pList.size() != 0)return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(list.contains(p.val)){
                pList = new ArrayList<>(list);
                pi = list.indexOf(Integer.valueOf(p.val));
            }
            if(list.contains(q.val)){
                qList = new ArrayList<>(list);
                qi = list.indexOf(Integer.valueOf(q.val));
            }
            return;
        }
        dfs(root.left,p,q,new ArrayList<>(list));
        dfs(root.right,p,q,new ArrayList<>(list));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}