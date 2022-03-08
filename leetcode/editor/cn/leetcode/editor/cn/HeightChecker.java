//学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。 
//
// 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。 
//
// 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。 
//
// 返回满足 heights[i] != expected[i] 的 下标数量 。 
//
// 
//
// 示例： 
//
// 
//输入：heights = [1,1,4,2,1,3]
//输出：3 
//解释：
//高度：[1,1,4,2,1,3]
//预期：[1,1,1,2,3,4]
//下标 2 、4 、5 处的学生高度不匹配。 
//
// 示例 2： 
//
// 
//输入：heights = [5,1,2,3,4]
//输出：5
//解释：
//高度：[5,1,2,3,4]
//预期：[1,2,3,4,5]
//所有下标的对应学生高度都不匹配。 
//
// 示例 3： 
//
// 
//输入：heights = [1,2,3,4,5]
//输出：0
//解释：
//高度：[1,2,3,4,5]
//预期：[1,2,3,4,5]
//所有下标的对应学生高度都匹配。 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <= 100 
// 1 <= heights[i] <= 100 
// 
// Related Topics 数组 计数排序 排序 
// 👍 96 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        Solution solution = new HeightChecker().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int heightChecker(int[] heights) {
            int[] nums = new int[101];
            for (int i = 0; i < heights.length; i++) {
                nums[heights[i]]++;
            }
            int res = 0;
            for (int i = 1,j = 0; i < nums.length; i++) {
                while (nums[i]-- > 0) {
                    if (heights[j++] != i) res++;
                }
            }
            return res;
        }

        public int heightChecker2(int[] heights) {
            //快排
            int[] except = Arrays.copyOfRange(heights, 0, heights.length);
            quickSort(except, 0, except.length - 1);
            int res = 0;
            for (int i = 0; i < heights.length; i++) {
                if (except[i] != heights[i]) res++;
            }
            return res;
        }

        public void quickSort(int[] nums, int low, int high) {
            if (low >= high) return;
            int base = nums[low];
            int i = low, j = high, temp = 0;
            while (i < j) {
                while (nums[j] >= base && i < j) {
                    j--;
                }
                while (nums[i] <= base && i < j) {
                    i++;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            nums[low] = nums[i];
            nums[i] = base;
            quickSort(nums, low, i - 1);
            quickSort(nums, i + 1, high);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}