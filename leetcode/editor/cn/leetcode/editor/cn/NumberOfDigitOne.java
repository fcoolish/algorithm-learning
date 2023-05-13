//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 514 👎 0

package leetcode.editor.cn;
public class NumberOfDigitOne{
    public static void main(String[] args){
        Solution solution = new NumberOfDigitOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int countDigitOne(int n) {
            int high = n;
            int low = 0;
            int cur = 0;
            int count = 0;
            int num = 1;
            while (high != 0 || cur != 0){
                cur = high % 10;
                high /= 10;
                if(cur == 0){
                    count += high * num;
                }else if(cur == 1){
                    count += high * num + 1 + low;
                }else{
                    count += (high + 1) * num;
                }
                low = cur * num + low;
                num *= 10;
            }
            return count;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}