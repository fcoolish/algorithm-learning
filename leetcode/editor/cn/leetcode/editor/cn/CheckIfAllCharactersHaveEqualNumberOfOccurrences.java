//给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。 
//
// 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abacbc"
//输出：true
//解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
// 
//
// 示例 2： 
//
// 输入：s = "aaabb"
//输出：false
//解释：s 中出现过的字符为 'a' 和 'b' 。
//'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母。 
// 
// Related Topics 哈希表 字符串 计数 👍 14 👎 0

package leetcode.editor.cn;
public class CheckIfAllCharactersHaveEqualNumberOfOccurrences{
    public static void main(String[] args){
        Solution solution = new CheckIfAllCharactersHaveEqualNumberOfOccurrences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] map = new int[26];
        for(int i =0;i < s.length();i++){
            map[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for(int i =0;i < 26;i++){
            if(count==0 && map[i] != 0){
                count = map[i];
                continue;
            }
            if(map[i] > 0 && count != map[i]){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}