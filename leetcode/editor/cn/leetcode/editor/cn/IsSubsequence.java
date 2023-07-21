//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 双指针 字符串 动态规划 👍 756 👎 0

package leetcode.editor.cn;
public class IsSubsequence{
    public static void main(String[] args){
        Solution solution = new IsSubsequence().new Solution();
        solution.isSubsequence("abc","ahbgdc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
            int sl = s.length(),tl = t.length();
            if(sl > tl)return false;
            if(sl == 0)return true;
            int i = 0,j = 0;
            while (i < sl && j < tl){
                if (s.charAt(i) == t.charAt(j)){
                    i++;
                }
                j++;
            }
            return i == sl;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}