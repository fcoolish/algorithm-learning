//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
//
// Related Topics 递归 数学 动态规划 👍 428 👎 0

package leetcode.editor.cn;
public class OneNzhengShuZhong1chuXianDeCiShuLcof{
    public static void main(String[] args){
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        solution.countDigitOne(12);
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