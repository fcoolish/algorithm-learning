//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
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
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 961 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

public class RemoveDuplicateLetters{
    public static void main(String[] args){
        Solution solution = new RemoveDuplicateLetters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
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