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
        solution.longestPalindrome("aaaa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public String longestPalindrome(String s) {
            String res = "";
            if(s.length() <= 1) return s;
            int n = s.length();
            for(int i =0;i < 2 * n - 1;i++){
                int l = i /2,r = i/2 + i %2;
                while (l >= 0 && r < n&&s.charAt(l) == s.charAt(r)){
                    if(r - l + 1 > res.length()){
                        res = s.substring(l,r + 1);
                    }
                    l--;
                    r++;
                }
            }
            return res;
        }

        String ans = "";
        public String longestPalindrome2(String s){
        ans = String.valueOf(s.charAt(0));
        int n = s.length();
        for(int i =1;i < n;i++){
            longStr(i - 1,i + 1,s);
        }
        for(int i =0;i < n - 1;i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                if(ans.length() < 2){
                    ans = s.substring(i,i + 2);
                }
                longStr(i - 1,i + 2,s);
            }
        }
        return ans;
    }

        private void longStr(int l, int r, String s){
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(r -l + 1> ans.length()){
                ans = s.substring(l,r + 1);
            }
            l--;
            r++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}