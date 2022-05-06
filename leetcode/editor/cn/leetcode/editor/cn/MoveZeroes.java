//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 
// 👍 1576 👎 0

package leetcode.editor.cn;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = new int[]{0,0,1};
        solution.moveZeroes(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0,n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }
            for (int i = index; i < n; i++) {
                nums[i] = 0;
            }
        }

        public void moveZeroes2(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    continue;
                }
                int r = n - 1;
                while (nums[r] == 0 && r > i) {
                    r--;
                }
                if (r > i) {
                    for (int j = i ; j < r; j++) {
                        int temp = nums[j + 1];
                        nums[j + 1] = nums[j];
                        nums[j] = temp;
                    }
                    i--;
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}