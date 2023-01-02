//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
// Related Topics 数学 字符串 👍 586 👎 0

package leetcode.editor.cn;
public class ExcelSheetColumnTitle{
    public static void main(String[] args){
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        solution.convertToTitle(701);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            char ch = (char)(columnNumber % 26 + 'A');
            ans.append(ch);
            columnNumber /= 26;
        }
        ans.reverse();
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}