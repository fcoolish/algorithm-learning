//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 
//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
//
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 584 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args){
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i =0;i < n;i++){
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            if(i + 1 - k >= 0){
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}