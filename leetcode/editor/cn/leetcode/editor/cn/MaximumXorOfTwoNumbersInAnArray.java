//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 位运算 字典树 数组 哈希表 👍 540 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MaximumXorOfTwoNumbersInAnArray{
    public static void main(String[] args){
        Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        static final  int HIGH_BIT = 30;
        public int findMaximumXOR(int[] nums) {
            int x = 0;
            for(int k = HIGH_BIT;k >= 0;k--){
                Set<Integer> seen = new HashSet<>();
                for(int num:nums){
                    seen.add(num >>k);
                }
                int xNext = x * 2 + 1;
                boolean found = false;
                for(int num:nums){
                    if(seen.contains(xNext ^ (num >>k))){
                        found = true;
                        break;
                    }
                }
                if(found){
                    x = xNext;
                }else{
                    x = xNext - 1;
                }
            }
            return x;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}