//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 1833 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FirstMissingPositive{
    public static void main(String[] args){
        Solution solution = new FirstMissingPositive().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i =0;i < n;i++){
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i =0;i < n;i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
    public int firstMissingPositive1(int[] nums) {
        int index = 0;
        int target = 1;
        Arrays.sort(nums);
        int n = nums.length;
        while (index < n){
            while (index < n && nums[index] != target){
                index++;
            }
            if(index < n && nums[index] == target){
                target++;
            }
            index++;
        }
        return target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}