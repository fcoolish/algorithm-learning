//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2276 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum{
    public static void main(String[] args){
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(arr,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length <= 1)return nums;
        int n = nums.length;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[n - k + 1];
        for(int i =0;i < n;i++){
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peek() <= i - k){
                queue.poll();
            }
            if(i + 1 >= k){
                ans[i - k + 1] = nums[queue.peek()];
            }
        }
        return ans;
    }
        //超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
       int n = nums.length;
       int[] ans = new int[n - k + 1];
       int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b - a);
        for(int i =0;i < k;i++){
            queue.add(nums[i]);
        }
        ans[index++] = queue.peek();
       for(int i = k ;i < nums.length;i++){
           queue.add(nums[i]);
           queue.remove(Integer.valueOf(nums[i - k]));
           ans[index++] = queue.peek();
       }
       return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}