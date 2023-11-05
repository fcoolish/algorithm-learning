//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
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
// Related Topics 栈 贪心 字符串 单调栈 👍 193 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

public class SmallestSubsequenceOfDistinctCharacters{
    public static void main(String[] args){
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public String smallestSubsequence(String s) {
            LinkedList<Character> deque = new LinkedList<>();
            int[] count = new int[26];
            boolean[] exists = new boolean[26];
            for(int i = 0;i < s.length();i++){
                count[s.charAt(i) - 'a']++;
            }
            for(int i = 0;i < s.length();i++){
                char temp =  s.charAt(i);
                if(!exists[temp - 'a']){
                    while (!deque.isEmpty() && deque.getLast() > temp && count[deque.getLast() - 'a'] > 0){
                        exists[deque.getLast() - 'a'] = false;
                        deque.removeLast();
                    }
                    deque.add(temp);
                    exists[temp - 'a'] = true;
                }
                count[temp - 'a']--;
            }
            StringBuilder sb = new StringBuilder();
            for(char ch:deque){
                sb.append(ch);
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}