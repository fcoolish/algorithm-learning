//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 977 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits{
    public static void main(String[] args){
        Solution solution = new RemoveKDigits().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n <= k)return "0";
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        for(int i = 0;i < len;i++){
            char dig = num.charAt(i);
            while (!deque.isEmpty() & k > 0 && deque.peekLast() > dig){
                deque.pollLast();
                k--;
            }
            deque.offerLast(dig);
        }
        for(int i = 0;i < k;i++){
            deque.pollLast();
        }
        StringBuilder res = new StringBuilder();
        boolean preZero = true;
        while (!deque.isEmpty()){
            char dig = deque.pollFirst();
            if(preZero && dig == '0'){
                continue;
            }
            preZero = false;
            res.append(dig);
        }
        return res.length() == 0 ? "0":res.toString();
    }




}
//leetcode submit region end(Prohibit modification and deletion)

}