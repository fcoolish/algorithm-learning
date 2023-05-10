//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 1068 👎 0

package leetcode.editor.cn;
public class UglyNumberIi{
    public static void main(String[] args){
        Solution solution = new UglyNumberIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1,p3 = 1,p5 = 1;
            for(int i = 2;i <= n;i++){
                int num = Math.min(dp[p2] * 2,Math.min(dp[p3] * 3,dp[p5] * 5));
                dp[i] = num;
                if(num == dp[p2] * 2){
                    p2++;
                }
                if(num == dp[p3] * 3){
                    p3++;
                }
                if(num == dp[p5] * 5){
                    p5++;
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}