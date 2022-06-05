//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 320 👎 0

package leetcode.editor.cn;
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args){
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)return 0;
        int l=0,r = nums.length - 1;
        while (l < r){
            int mid = (l + r) >>1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(nums[l] != target) return  0;
        int t = l;
        l = 0;
        r = nums.length - 1;
        while (l < r){
            int mid = (l + r + 1) >>1 ;
            if(nums[mid] <= target){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return r - t + 1;
    }

    public int search2(int[] nums, int target) {
            int count = 0;
            for(int num:nums){
                if(num > target)break;
                if(target == num){
                    count++;
                }
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}