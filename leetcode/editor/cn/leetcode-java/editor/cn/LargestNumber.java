//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1138 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber{
    public static void main(String[] args){
        Solution solution = new LargestNumber().new Solution();
        int[] nums = {3,30,34,5,9};
        solution.largestNumber(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs  = new String[n];
        for(int i = 0;i < n;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(a,b) -> (b + a).compareTo(a + b));
        if(strs[0].equals("0"))return "0";
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}