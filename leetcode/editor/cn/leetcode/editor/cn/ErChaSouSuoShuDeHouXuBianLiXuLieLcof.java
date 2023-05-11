//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
//
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 722 👎 0

package leetcode.editor.cn;
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args){
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int n  = postorder.length;
        return dfs(postorder,0,n - 1);
    }

    private boolean dfs(int[] postorder,int i,int j){
        if(i >= j)return true;
        int p = i;
        while (postorder[p] < postorder[j])p++;
        int m = p;
        while (postorder[p] > postorder[j])p++;
        return p == j && dfs(postorder,i,m - 1) && dfs(postorder,m,j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}