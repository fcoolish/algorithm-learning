//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。 
//
// 请你计算并返回该式的最大值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,5,2]
//输出：12 
//解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
// 3*4 = 12 。 
// 
//
// 示例 2： 
//
// 输入：nums = [1,5,4,5]
//输出：16
//解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,7]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 1 <= nums[i] <= 10^3 
// 
// Related Topics 数组 排序 堆（优先队列） 
// 👍 30 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfTwoElementsInAnArray().new Solution();
        int[] num = new int[]{3,4,5,2};
        solution.maxProduct(num);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //topk
        public int maxProduct(int[] nums) {
            int max1 = 0,max2 = 0;
            for (int num:nums) {
                if(num > max1){
                    max2 = max1;
                    max1 = num;
                }else if(num > max2){
                    max2 = num;
                }
            }
            return (max1 - 1) * (max2 - 1);
        }
        //topk
        public int maxProduct2(int[] nums) {
            Queue<Integer> heap = new PriorityQueue<>(2);
            for (int i = 0; i < nums.length; i++) {
                if (heap.size() < 2) {
                    heap.add(nums[i]);
                } else if(heap.size() == 2) {
                    if (nums[i] > heap.peek()) {
                        heap.poll();
                        heap.offer(nums[i]);
                    }
                }
            }
            int num1 = heap.peek() - 1;
            heap.poll();
            int num2 = heap.peek() - 1;
            return num1 * num2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}