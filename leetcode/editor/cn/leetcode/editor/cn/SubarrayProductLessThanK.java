//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// Related Topics 数组 滑动窗口 👍 724 👎 0

package leetcode.editor.cn;
public class SubarrayProductLessThanK{
    public static void main(String[] args){
        Solution solution = new SubarrayProductLessThanK().new Solution();
        int[] arr = {10,5,2,6};
        solution.numSubarrayProductLessThanK(arr,100);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length,ret = 0;
        int prod = 1,i = 0;
        for(int j = 0;j < n;j++){
            prod *= nums[j];
            while (i <= j && prod >= k){
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return  ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}