//给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
// 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,2]
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁶ 
// 
// Related Topics 贪心 数组 数学 排序 👍 189 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class LargestPerimeterTriangle{
    public static void main(String[] args){
        Solution solution = new LargestPerimeterTriangle().new Solution();
        int[] arr = new int[]{2,1,2};
        solution.largestPerimeter(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i =nums.length - 1;i > 1;i--){
            if(nums[i - 1] + nums[i - 2] > nums[i]){
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}