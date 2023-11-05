//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
//
// Related Topics 数组 双指针 排序 👍 124 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneFGaJU{
    public static void main(String[] args){
        Solution solution = new OneFGaJU().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int first = 0;first < n;first++){
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int target = -nums[first];
            for(int second = first + 1;second < n;second++){
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                int third = n - 1;
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}