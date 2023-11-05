//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 👍 194 👎 0

package leetcode.editor.cn;
public class NumberOfSegmentsInAString{
    public static void main(String[] args){
        Solution solution = new NumberOfSegmentsInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        StringBuilder word = new StringBuilder();
        int count = 0;
        for(int i = 0;i <= s.length();i++){
            if(i == s.length()){
                if(word.length() > 0){
                    count++;
                }
            }else if(s.charAt(i) == ' ' && word.length() > 0){
                count++;
                word.delete(0,word.length());
            }else if(s.charAt(i) != ' '){
                word.append(s.charAt(i));
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}