//给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输入:7 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
// Related Topics 贪心 哈希表 字符串 👍 484 👎 0

package leetcode.editor.cn;
public class LongestPalindrome{
    public static void main(String[] args){
        Solution solution = new LongestPalindrome().new Solution();
        solution.longestPalindrome("AAAAAA");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int l = s.length();
        int[] arr = new int[58];
        for(int i = 0;i < l;i++){
            arr[s.charAt(i) - 'A']++;

        }
        int count = 0;
        for(int i = 0;i < 58;i++){
            count =count +  arr[i]/2 * 2;
        }
        return count < l ? (count + 1):count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}