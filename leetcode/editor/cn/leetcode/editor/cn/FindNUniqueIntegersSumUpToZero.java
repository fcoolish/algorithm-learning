//给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：[-7,-1,1,3,4]
//解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
// 
//
// 示例 2： 
//
// 输入：n = 3
//输出：[-1,0,1]
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 数组 数学 
// 👍 59 👎 0

package leetcode.editor.cn;

public class FindNUniqueIntegersSumUpToZero {
    public static void main(String[] args) {
        Solution solution = new FindNUniqueIntegersSumUpToZero().new Solution();
        solution.sumZero(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sumZero(int n) {
            int[] res = new int[n];
            boolean isEvenNum = n % 2 == 0 ? true : false;
            int index = 1;
            int length = isEvenNum ? n : n - 1;
            for (int i = 0; i < length; i = i + 2) {
                res[i] = -index;
                res[i + 1] = index;
                index++;
            }
            if (!isEvenNum) {
                res[n - 1] = 0;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}