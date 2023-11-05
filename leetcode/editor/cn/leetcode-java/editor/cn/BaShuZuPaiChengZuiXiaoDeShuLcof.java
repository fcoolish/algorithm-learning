//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
//
// Related Topics 贪心 字符串 排序 👍 636 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args){
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        String[] strs = new String[nums.length];
        int index = 0;
        for(int num:nums){
            strs[index++] = String.valueOf(num);
        }
        Arrays.sort(strs, (x,y) -> (x + y).compareTo((y + x)));
        for(String str:strs){
            ans.append(str);
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}