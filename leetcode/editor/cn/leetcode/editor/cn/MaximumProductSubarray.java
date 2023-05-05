//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2008 👎 0

package leetcode.editor.cn;
public class MaximumProductSubarray{
    public static void main(String[] args){
        Solution solution = new MaximumProductSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int maxF = nums[0],minF = nums[0];
        int ans = nums[0];
        for(int i = 1;i < nums.length;i++){
            int num = nums[i];
            int max = maxF,min = minF;
            maxF = Math.max(num * max, Math.max(num,num * min));
            minF = Math.min(num * min, Math.min(num,num * max));
            ans = Math.max(maxF,ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}