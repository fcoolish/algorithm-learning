//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1141 👎 0

package leetcode.editor.cn;

public class PalindromicSubstrings{
    public static void main(String[] args){
        Solution solution = new PalindromicSubstrings().new Solution();
        solution.countSubstrings("aaa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int countSubstrings(String s){
        int n = s.length(),cnt = n;
        for(int i = 0;i < n;i++){
            int l = i - 1,r = i + 1;
            while (l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                    cnt++;
                }else{
                    break;
                }
            }
        }
        for(int i = 0;i < n - 1;i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                cnt++;
                int l = i - 1,r = i + 2;
                while (l >= 0 && r < n){
                    if(s.charAt(l) == s.charAt(r)){
                        l--;
                        r++;
                        cnt++;
                    }else{
                        break;
                    }
                }
            }

        }
        return cnt;
    }
    public int countSubstrings1(String s) {
        if(s.length() <= 1) return 1;
        int cnt = 0;
        int n = s.length();
        for(int i =0;i < 2 * n - 1;i++){
            int l = i /2,r = i/2 + i %2;
            while (l >= 0 && r < n&&s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                cnt++;
            }
        }
        return cnt;
    }
    }


//leetcode submit region end(Prohibit modification and deletion)

}