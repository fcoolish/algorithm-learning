//给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。 
//
// 返回交换 任意 次之后 num 的 最大 可能值。 
//
// 
//
// 示例 1： 
//
// 输入：num = 1234
//输出：3412
//解释：交换数字 3 和数字 1 ，结果得到 3214 。
//交换数字 2 和数字 4 ，结果得到 3412 。
//注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
//注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
// 
//
// 示例 2： 
//
// 输入：num = 65875
//输出：87655
//解释：交换数字 8 和数字 6 ，结果得到 85675 。
//交换数字 5 和数字 7 ，结果得到 87655 。
//注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁹ 
// 
// Related Topics 排序 堆（优先队列） 👍 19 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class LargestNumberAfterDigitSwapsByParity{
    public static void main(String[] args){
        Solution solution = new LargestNumberAfterDigitSwapsByParity().new Solution();
        solution.largestInteger(65875);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestInteger(int num){
        PriorityQueue<Integer> q1 = new PriorityQueue<>((a,b) -> b- a);
        PriorityQueue<Integer> q2 = new PriorityQueue<>((a,b) -> b- a);
        String str = String.valueOf(num);
        for(int i =0;i < str.length();i++){
            int nn = str.charAt(i) - '0';
            if(nn % 2 == 0){
                q2.offer(nn);
            }else{
                q1.offer(nn);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i =0;i < str.length();i++){
            int nn = str.charAt(i) - '0';
            if(nn % 2 == 0){
                ans.append(q2.poll());
            }else{
                ans.append(q1.poll());
            }
        }
        return Integer.parseInt(ans.toString());
    }
    public int largestInteger1(int num) {
        StringBuilder numStr = new StringBuilder();
        numStr.append(num);
        int l = numStr.length();
        for(int i =0;i < l - 1;i++){
            for(int j = i + 1;j < l;j++){
                int n = numStr.charAt(i) - '0' + numStr.charAt(j) - '0';
                if(n % 2 == 0 && numStr.charAt(i) < numStr.charAt(j)){
                    char c = numStr.charAt(i);
                    numStr.setCharAt(i,numStr.charAt(j));
                    numStr.setCharAt(j,c);
                }
            }
        }
        return Integer.valueOf(numStr.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}