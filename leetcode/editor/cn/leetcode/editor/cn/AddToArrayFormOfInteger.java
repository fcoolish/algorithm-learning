//整数的 数组形式 num 是按照从左到右的顺序表示其数字的数组。 
//
// 
// 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。 
// 
//
// 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：num = [1,2,0,0], k = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 
//输入：num = [2,7,4], k = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 
//输入：num = [2,1,5], k = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10⁴ 
// 0 <= num[i] <= 9 
// num 不包含任何前导零，除了零本身 
// 1 <= k <= 10⁴ 
// 
// Related Topics 数组 数学 👍 203 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger{
    public static void main(String[] args){
        Solution solution = new AddToArrayFormOfInteger().new Solution();
        int[] nums = new int[]{1,2,3};
        solution.addToArrayForm(nums,912);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = num.length;
        for(int i =n - 1;i >= 0;i--){
            int sum = num[i] + k % 10;
            k /= 10;
            if(sum >= 10){
                k++;
                sum -= 10;
            }
            ans.add(0,sum);
        }
        for(;k > 0;k /= 10){
            ans.add(0,k % 10);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}