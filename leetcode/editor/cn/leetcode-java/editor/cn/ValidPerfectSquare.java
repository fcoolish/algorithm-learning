//给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。 
//
// 不能使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
//解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
//解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 467 👎 0

package leetcode.editor.cn;
public class ValidPerfectSquare{
    public static void main(String[] args){
        Solution solution = new ValidPerfectSquare().new Solution();
        solution.isPerfectSquare(16);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0,r = num;
        while (l <= r){
            int mid = l + (r - l)/2;
            double res = mid * 1.0 * mid;
            if(res== num){
                return true;
            }else if(res > num){
                r = mid - 1;
            }else{
                l = mid + 1;
            }}
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}