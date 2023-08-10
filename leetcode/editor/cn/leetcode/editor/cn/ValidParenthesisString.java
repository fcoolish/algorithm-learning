//给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是有效字符串返回 true 。 
//
// 有效字符串符合如下规则： 
//
// 
// 任何左括号 '(' 必须有相应的右括号 ')'。 
// 任何右括号 ')' 必须有相应的左括号 '(' 。 
// 左括号 '(' 必须在对应的右括号之前 ')'。 
// '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "(*)"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(*))"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 为 '('、')' 或 '*' 
// 
//
// Related Topics 栈 贪心 字符串 动态规划 👍 600 👎 0

package leetcode.editor.cn;
public class ValidParenthesisString{
    public static void main(String[] args){
        Solution solution = new ValidParenthesisString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}