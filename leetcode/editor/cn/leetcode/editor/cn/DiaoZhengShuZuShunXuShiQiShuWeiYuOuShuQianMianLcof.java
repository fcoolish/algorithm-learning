//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 223 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args){
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        int[] nums = new int[]{1,11,14};
        solution.exchange(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] exchange(int[] nums) {
            int n = nums.length;
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();
            for(int i =0;i < n;i++){
                if(nums[i] % 2 == 0){
                    even.add(nums[i]);
                }else{
                    odd.add(nums[i]);
                }
            }
            int len = odd.size();
            for(int i =0;i < len;i++){
                nums[i] = odd.get(i);
            }
            for(int i =0;i < even.size();i++){
                nums[i + len] = even.get(i);
            }
            return nums;
        }

        public int[] exchange2(int[] nums) {
        int n = nums.length - 1;
        int left = 0,right = n;
        while(left < right){
            while(nums[left] % 2 != 0 && left < right){
                left++;
            }
            while(nums[right] % 2 != 1 && right > left){
                right--;
            }
            if(nums[left] % 2 == 0 && nums[right] % 2 == 1){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
            right--;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}