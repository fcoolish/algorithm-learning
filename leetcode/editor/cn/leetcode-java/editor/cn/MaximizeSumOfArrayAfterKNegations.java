//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -100 <= nums[i] <= 100 
// 1 <= k <= 10⁴ 
// 
// Related Topics 贪心 数组 排序 👍 257 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations{
    public static void main(String[] args){
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
        int[] nums = new int[]{-2,5,0,2,-2};
        solution.largestSumAfterKNegations(nums,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        return k %2 == 0 ? sum : (sum - 2 * nums[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}