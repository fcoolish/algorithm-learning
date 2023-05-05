//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6461 👎 0

package leetcode.editor.cn;
public class LongestPalindromicSubstring{
    public static void main(String[] args){
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxL = 1,index = 0;
        for(int i = 0;i < n;i++){
            int l = i - 1,r =  i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if(maxL < (r - l + 1)){
                    maxL = r - l + 1;
                    index = l;
                }
                l--;
                r++;
            }
        }
        for(int i = 0;i < n - 1;i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                if(maxL < 2){
                    maxL = 2;
                    index = i;
                }
                int l = i - 1,r = i + 2;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                    if(maxL < (r - l + 1)){
                        maxL = r - l + 1;
                        index = l;
                    }
                    l--;
                    r++;
                }
            }
        }
        return s.substring(index,index + maxL);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}