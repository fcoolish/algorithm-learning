//给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ： 
//
// 
// nums[a] + nums[b] + nums[c] == nums[d] ，且 
// a < b < c < d 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,6]
//输出：1
//解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,4,5]
//输出：0
//解释：[3,3,6,4,5] 中不存在满足要求的四元组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,1,3,5]
//输出：4
//解释：满足要求的 4 个四元组如下：
//- (0, 1, 2, 3): 1 + 1 + 1 == 3
//- (0, 1, 3, 4): 1 + 1 + 3 == 5
//- (0, 2, 3, 4): 1 + 1 + 3 == 5
//- (1, 2, 3, 4): 1 + 1 + 3 == 5
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 50 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 枚举 
// 👍 108 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialQuadruplets{
    public static void main(String[] args){
        Solution solution = new CountSpecialQuadruplets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length,res = 0;
        int[] count = new int[1001];
        for(int c= n - 2;c >=2;c--){
            count[nums[c + 1]]++;
            for(int a =0;a < c;a++){
                for(int b = a + 1;b < c;b++){
                    res +=count[nums[a] + nums[b]+nums[c]];
                }
            }
        }
        return res;
    }

    public int countQuadruplets2(int[] nums) {
            int n = nums.length,res = 0;
            for(int i =0;i < n - 3;i++){
                for(int j = i + 1;j < n - 2;j++){
                    for(int m = j +1;m < n - 1;m++){
                        for(int k = m + 1;k < n;k++){
                            if((nums[i] + nums[j] + nums[m]) ==nums[k]){
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}