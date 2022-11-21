//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 921 👎 0

package leetcode.editor.cn;
public class AddBinary{
    public static void main(String[] args){
        Solution solution = new AddBinary().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int temp =0;
        int al = a.length() - 1;
        int bl = b.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (al >= 0 || bl >= 0 || temp != 0){
            int na = al >= 0 ? a.charAt(al) - '0':0;
            int nb = bl >= 0 ? b.charAt(bl) - '0':0;
            int sum = na + nb + temp;
            ans.insert(0,sum % 2);
            temp = sum /2;
            al--;
            bl--;
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}