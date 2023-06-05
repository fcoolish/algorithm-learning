//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 
//
// 
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
//
// Related Topics 字符串 动态规划 回溯 👍 71 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IDBivT{
    public static void main(String[] args){
        Solution solution = new IDBivT().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
           dfs(0,0,n,new StringBuilder());
           return ans;
    }

    public void dfs(int left,int right,int n,StringBuilder sb){
        if(left + right == 2 * n){
            ans.add(new String(sb.toString()));
            return;
        }
        if(left < n){
            sb.append("(");
            dfs(left + 1,right,n,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(")");
            dfs(left,right + 1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}