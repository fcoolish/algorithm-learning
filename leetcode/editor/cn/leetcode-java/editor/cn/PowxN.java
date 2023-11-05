//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n 是一个整数 
// 要么 x 不为零，要么 n > 0 。 
// -104 <= xⁿ <= 104 
// 
//
// Related Topics 递归 数学 👍 1181 👎 0

package leetcode.editor.cn;
public class PowxN{
    public static void main(String[] args){
        Solution solution = new PowxN().new Solution();
        solution.myPow(2,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow1(double x, int n) {
        if(n == 0) return 1;
        double ans = 1.0;
        long cnt = n > 0 ? n:-(long)n;
        double xc = x;
        while (cnt > 0){
            if(cnt %2 == 1){
                ans *= xc;
            }
            xc *=xc;
            cnt /=2;
        }
        return n > 0 ? ans:1/ans;
    }

    public double myPow(double x, int n){
        if(n == 0)return 1;
        if(n == 1) return x;
        long cnt = n;
        return n > 0 ? getValue(x,cnt):1.0/getValue(x,-cnt);
    }

    public double getValue(double x,long cnt){
        if(cnt == 0){
            return 1;
        }
        double y = getValue(x,cnt/2);
        return cnt % 2 == 0 ? y * y :y * y * x;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}