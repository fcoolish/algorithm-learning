//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 👍 290 👎 0

package leetcode.editor.cn;
public class LongestContinuousIncreasingSubsequence{
    public static void main(String[] args){
        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
        int[] nums = new int[]{1,3,5,4,2,3,4,5};
        solution.findLengthOfLCIS(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int findLengthOfLCIS(int[] nums) {
            int max = 1;
            int l =0;
            int n = nums.length;
            for(int i =0;i < n;i++){
                if(i == n - 1 || nums[i] >= nums[i + 1]){
                    max = Math.max(i - l + 1,max);
                    l = i + 1;
                }
            }
            return max;
        }

        public int findLengthOfLCIS2(int[] nums) {
        int max = 1;
        int l =0,r = 0;
        int n = nums.length;
        for(int i =0;i < n;i++){
            if(i == n - 1 || nums[i] >= nums[i + 1]){
                r = i;
                max = Math.max(r - l + 1,max);
                l = i + 1;
            }else{
                r++;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}