//给你一个字符串 s，最多 可以从中删除一个字符。 
//
// 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "abca"
//输出：true
//解释：你可以删除字符 'c' 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abc"
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 560 👎 0

package leetcode.editor.cn;
public class ValidPalindromeIi{
    public static void main(String[] args){
        Solution solution = new ValidPalindromeIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int l =0,r = s.length() - 1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
             return isPalindrome(s,l + 1,r) || isPalindrome(s,l,r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String str,int l,int r){
        while (l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}