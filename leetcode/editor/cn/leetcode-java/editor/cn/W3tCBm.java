//给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: [0,1,1]
//解释: 
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2: 
//
// 
//输入: n = 5
//输出: [0,1,1,2,1,2]
//解释:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 说明 : 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶: 
//
// 
// 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为 O(n) 。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。 
// 
//
// 
//
// 
// 注意：本题与主站 338 题相同：https://leetcode-cn.com/problems/counting-bits/ 
//
// Related Topics 位运算 动态规划 👍 132 👎 0

package leetcode.editor.cn;
public class W3tCBm{
    public static void main(String[] args){
        Solution solution = new W3tCBm().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            ans[0] = 0;
            for(int i = 1;i <=n;i++){
                ans[i] = ans[i >> 1] + (i & 1);
            }
            return ans;
        }

        public int[] countBits1(int n) {
            int[] ans = new int[n + 1];
            for(int i = 0;i <=n;i++){
                int x = i;
                int cnt = 0;
                while (x > 0){
                    x = x &(x - 1);
                    cnt++;
                }
                ans[i] = cnt;
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}