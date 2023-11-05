//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
//
// Related Topics 位运算 数组 👍 443 👎 0

package leetcode.editor.cn;
public class ShuZuZhongShuZiChuXianDeCiShuIiLcof{
    public static void main(String[] args){
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        int[] arr = {3,4,3,3};
        solution.singleNumber(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0;i < 32;i++){
            int cnt = 0;
            int index = 1 << i;
            for(int num:nums){
                if((num & index) != 0){
                    cnt++;
                }
            }
            if(cnt % 3 != 0){
                ans |= index;
            }
        }
        return ans;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}