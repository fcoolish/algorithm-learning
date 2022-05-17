//如果数组是单调递增或单调递减的，那么它是 单调 的。 
//
// 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = 
//nums[j]，那么数组 nums 是单调递减的。 
//
// 当给定的数组 nums 是单调数组时返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：nums = [6,5,4,4]
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 👍 163 👎 0

package leetcode.editor.cn;
public class MonotonicArray{
    public static void main(String[] args){
        Solution solution = new MonotonicArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if(n == 1)return true;
        boolean add = true;
        boolean sub = true;
        for(int i =0;i < n - 1;i++){
            if(nums[i + 1] < nums[i]){
                add = false;
            }else if(nums[i + 1] > nums[i]){
                sub = false;
            }
            if(!add && !sub)return false;
        }
        return add || sub;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}