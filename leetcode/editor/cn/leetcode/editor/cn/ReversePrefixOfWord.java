//给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（
//含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。 
//
// 
// 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将
//会是 "dcbaefd" 。 
// 
//
// 返回 结果字符串 。 
//
// 
//
// 示例 1： 
//
// 输入：word = "abcdefd", ch = "d"
//输出："dcbaefd"
//解释："d" 第一次出现在下标 3 。 
//反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
// 
//
// 示例 2： 
//
// 输入：word = "xyxzxe", ch = "z"
//输出："zxyxxe"
//解释："z" 第一次也是唯一一次出现是在下标 3 。
//反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "zxyxxe" 。
// 
//
// 示例 3： 
//
// 输入：word = "abcd", ch = "z"
//输出："abcd"
//解释："z" 不存在于 word 中。
//无需执行反转操作，结果字符串是 "abcd" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 250 
// word 由小写英文字母组成 
// ch 是一个小写英文字母 
// 
// Related Topics 双指针 字符串 👍 62 👎 0

package leetcode.editor.cn;
public class ReversePrefixOfWord{
    public static void main(String[] args){
        Solution solution = new ReversePrefixOfWord().new Solution();
        solution.reversePrefix("abcdefd",'d');
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reversePrefix(String word, char ch) {
       StringBuilder sb = new StringBuilder();
       int index = 0;int len = word.length();
        for(int i = 0;i < len;i++) {
            sb.insert(0,word.charAt(i));
            if(word.charAt(i) == ch){
                index = i;
                break;
            }
        }
        if(index == 0)return word;
        for(int i = index + 1;i < len;i++){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}