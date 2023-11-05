//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 数学 👍 1034 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PlusOne{
    public static void main(String[] args){
        Solution solution = new PlusOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] plusOne(int[] digits){
        int n = digits.length;
        int carry = 1;
        for(int i = n - 1;i >= 0;i--){
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum /10;
            if(carry == 0)return digits;
        }
        digits = new int[n + 1];
        digits[0] = carry;
        return digits;
    }
    public int[] plusOne1(int[] digits){
        int index = digits.length - 1;
        int ret = 1;
        List<Integer> list = new ArrayList<>();
        while (index >=0 || ret > 0){
            int num = index >= 0 ? digits[index]:0;
            index--;
            int sum = num + ret;
            list.add(0,sum % 10);
            ret = sum /10;
        }
        int[] ans = new int[list.size()];
        for(int i =0;i < list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}