//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1054 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        int[] arr = {2,6,4,8,10,9,15};
        solution.findUnsortedSubarray1(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int[] newArr = Arrays.copyOfRange(nums, 0, n);
            Arrays.sort(newArr);
            int l = 0, r = nums.length - 1;
            while (l < n && newArr[l] == nums[l]) {
                l++;
            }
            if (l == n) return 0;
            while (r > 0 && newArr[r] == nums[r]) {
                r--;
            }
            return r - l + 1;
        }

        public int findUnsortedSubarray1(int[] nums) {
            //初始化
            int len = nums.length;
            int min = nums[len - 1];
            int max = nums[0];
            int begin = 0, end = -1;
            //遍历
            for (int i = 0; i < len; i++) {
                if (nums[i] < max) {      //从左到右维持最大值，寻找右边界end
                    end = i;
                } else {
                    max = nums[i];
                }

                if (nums[len - i - 1] > min) {    //从右到左维持最小值，寻找左边界begin
                    begin = len - i - 1;
                } else {
                    min = nums[len - i - 1];
                }
            }
            return end - begin + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}