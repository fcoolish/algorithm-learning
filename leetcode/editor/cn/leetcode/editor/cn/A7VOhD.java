//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
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
// 
//
// 
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
//
// Related Topics 字符串 动态规划 👍 95 👎 0

package leetcode.editor.cn;
public class A7VOhD{
    public static void main(String[] args){
        Solution solution = new A7VOhD().new Solution();
        solution.countSubstrings("aaa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int countSubstrings(String s){
        int ans = 0;
        int n = s.length();
        for(int i =0;i < 2 * n - 1;i++){
            int l = i/2,r = l + i%2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
    public int countSubstrings1(String s) {
        int sum = 0;
        int n =s.length();
        for(int i =1;i <= n;i++){
            for(int j =0;j <= n - i;j++){
                String str = s.substring(j,j + i);
                if(check(str)){
                    sum++;
                }
            }
        }
        return sum;
    }

    public boolean check(String str){
        int l =0,r = str.length() - 1;
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