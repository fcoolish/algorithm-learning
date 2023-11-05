//给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。 
//
// 接下来，你需要按下述步骤操作： 
//
// 
// 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * origi
//nal）。 
// 否则，停止这一过程。 
// 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。 
// 
//
// 返回 original 的 最终 值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,3,6,1,12], original = 3
//输出：24
//解释： 
//- 3 能在 nums 中找到。3 * 2 = 6 。
//- 6 能在 nums 中找到。6 * 2 = 12 。
//- 12 能在 nums 中找到。12 * 2 = 24 。
//- 24 不能在 nums 中找到。因此，返回 24 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,7,9], original = 4
//输出：4
//解释：
//- 4 不能在 nums 中找到。因此，返回 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i], original <= 1000 
// 
// Related Topics 数组 哈希表 排序 模拟 
// 👍 8 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {
    public static void main(String[] args) {
        Solution solution = new KeepMultiplyingFoundValuesByTwo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //解法一 遍历+循环
        public int findFinalValue2(int[] nums, int original) {
            while (true) {
                boolean exists = false;
                for (int i = 0; i < nums.length; i++)
                    if (nums[i] == original) {
                        exists = true;
                        original *= 2;
                    }
                if (!exists) {
                    break;

                }
            }
            return original;
        }
        //解法二 排序后遍历
        public int findFinalValue(int[] nums, int original) {
            //排序
            quickSort(nums,0,nums.length - 1);
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == original) {
                    original *= 2;
                }
            return original;
        }

        //解法三 哈希表
        public int findFinalValue1(int[] nums, int original) {
            //排序
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++){
                set.add(nums[i]);
            }
            while (set.contains(original)){
                original *= 2;
            }
            return original;
        }

        private void quickSort(int[] nums,int low,int high){
            if(low >=high)return;
            int i = low,j = high,temp = 0;
            int base = nums[low];
            while(i < j){
                while(nums[j] >= base && i <j){
                    j--;
                }
                while(nums[i] <= base && i <j){
                    i++;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            nums[low] = nums[i];
            nums[i] = base;
            quickSort(nums, low, i - 1);
            quickSort(nums,i + 1,high);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}