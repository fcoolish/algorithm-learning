//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2414 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram{
    public static void main(String[] args){
        Solution solution = new LargestRectangleInHistogram().new Solution();
        int[] arr = {2,1,5,6,2,3};
        solution.largestRectangleArea(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Deque<Integer> mStack = new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            while (!mStack.isEmpty() && heights[mStack.peek()] >= heights[i]){
                mStack.pop();
            }
            l[i] = mStack.isEmpty() ? - 1:mStack.peek();
            mStack.push(i);
        }
        mStack.clear();
        for(int i = n - 1;i >= 0;i--){
            while (!mStack.isEmpty() && heights[mStack.peek()] >= heights[i]){
                mStack.pop();
            }
            r[i] = mStack.isEmpty() ? n:mStack.peek();
            mStack.push(i);
        }
        for(int i = 0;i < n;i++){
            max = Math.max(max,(r[i] - l[i] - 1) * heights[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}