//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9110 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
            int sl = s.length();
            int ans = 0;
            int l = 0, r  = 0;
            while (r < sl){
                while (list.contains(s.charAt(r))){
                    list.remove(Character.valueOf(s.charAt(l)));
                    l++;
                }
                list.add(s.charAt(r));
                ans = Math.max(r - l + 1,ans);
                r++;
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}