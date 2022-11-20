//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 52 👎 0

package leetcode.editor.cn;
public class JFETK5{
    public static void main(String[] args){
        Solution solution = new JFETK5().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() -1;
        int temp =0;
        StringBuilder ans = new StringBuilder();
        while (l1 >= 0 || l2 >= 0 || temp != 0){
            int n1 = l1 >= 0 ? a.charAt(l1) - '0': 0;
            int n2 = l2 >= 0 ? b.charAt(l2) - '0': 0;
            int sum = n1 + n2 + temp;
            ans.insert(0,sum % 2);
            temp = sum / 2;
            l1--;
            l2--;
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}