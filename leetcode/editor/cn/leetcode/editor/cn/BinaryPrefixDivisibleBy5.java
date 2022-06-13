//给定一个二进制数组 nums ( 索引从0开始 )。 
//
// 我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。 
//
// 
// 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。 
// 
//
// 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,1]
//输出：[true,false,false]
//解释：
//输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为 true 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1]
//输出：[false,false,false]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 仅为 0 或 1 
// 
// Related Topics 数组 👍 139 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5{
    public static void main(String[] args){
        Solution solution = new BinaryPrefixDivisibleBy5().new Solution();
        int[] nums = new int[]{0,1,1,1,1,1};
        solution.prefixesDivBy5(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;
        for(int i =0;i < n;i++){
            prefix = ((prefix << 1) + nums[i])  % 5;
            ans.add(prefix == 0);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}