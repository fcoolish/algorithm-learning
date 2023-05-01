//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 3171 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] arr = {0, 1, 0, 3, 2, 3};
        solution.lengthOfLIS(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if(nums.length == 0)return 0;
            int[] dp = new int[n];
            int max = 1;
            dp[0]= 1;
            for(int i = 1;i < n;i++){
                dp[i] = 1;
                for(int j = 0;j < i;j++){
                    if(nums[i] > nums[j]){
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
                max = Math.max(max,dp[i]);
            }
            return max;
        }


        //解法二
        int res = 0;
        //回溯超时
        public int lengthOfLIS1(int[] nums) {
            int n = nums.length;
            List<Integer> op = new ArrayList<>();
            for (int num : nums) {
                op.add(num);
            }
            backtrack(n, op, new ArrayList<>(), 0);
            return res;
        }

        public void backtrack(int n, List<Integer> op, List<Integer> list, int index) {
            if (index == n) {
                res = Math.max(res, list.size());
                return;
            }
            backtrack(n, op, list, index + 1);
            if (list.size() == 0 || (list.size() > 0 && op.get(index) > list.get(list.size() - 1))) {
                list.add(op.get(index));
                backtrack(n, op, list, index + 1);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}