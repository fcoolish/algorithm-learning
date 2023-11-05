//给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 
//输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 
//输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 哈希表 字符串 排序 👍 150 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class CheckPermutationLcci{
    public static void main(String[] args){
        Solution solution = new CheckPermutationLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        Arrays.sort(sc1);
        Arrays.sort(sc2);
        return new String(sc1).equals(new String(sc2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}