//给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "foobar", letter = "o"
//输出：33
//解释：
//等于字母 'o' 的字符在 s 中占到的百分比是 2 / 6 * 100% = 33% ，向下取整，所以返回 33 。
// 
//
// 示例 2： 
//
// 
//输入：s = "jjjj", letter = "k"
//输出：0
//解释：
//等于字母 'k' 的字符在 s 中占到的百分比是 0% ，所以返回 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 由小写英文字母组成 
// letter 是一个小写英文字母 
// 
// Related Topics 字符串 👍 8 👎 0

package leetcode.editor.cn;
public class PercentageOfLetterInString{
    public static void main(String[] args){
        Solution solution = new PercentageOfLetterInString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int percentageLetter(String s, char letter) {
        int l = s.length();
        int count = 0;
        for(int i= 0;i < s.length();i++){
            if(s.charAt(i) == letter){
                count++;
            }
        }
        return count* 100 /l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}