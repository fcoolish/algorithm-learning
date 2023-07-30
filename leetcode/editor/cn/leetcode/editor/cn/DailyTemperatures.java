//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1471 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class DailyTemperatures{
    public static void main(String[] args){
        Solution solution = new DailyTemperatures().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int tem = stack.pop();
                temperatures[tem] = i - tem;
            }
            stack.push(i);
        }
        return temperatures;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}