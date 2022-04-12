//给定一个非负整数数组 nums， nums 中一半整数是 奇数 ，一半整数是 偶数 。 
//
// 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。 
//
// 你可以返回 任何满足上述条件的数组作为答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 104 
// nums.length 是偶数 
// nums 中一半是偶数 
// 0 <= nums[i] <= 1000 
// 
//
// 
//
// 进阶：可以不使用额外空间解决问题吗？ 
// Related Topics 数组 双指针 排序 
// 👍 235 👎 0

package leetcode.editor.cn;

public class SortArrayByParityIi {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParityIi().new Solution();
        int[] nums = new int[]{4, 2, 7, 5};
        solution.sortArrayByParityII(nums);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] sortArrayByParityII(int[] nums) {
            int length = nums.length;
            int j = 1;
            for (int i = 0; i < length; i = i+2) {
                if (nums[i] % 2 != 0) {
                    while (nums[j] % 2 != 0){
                        j +=2;
                    }
                    swap(nums,i,j);
                }
            }
            return nums;
        }


        public int[] sortArrayByParityII2(int[] nums) {
            int length = nums.length;
            for (int i = 0; i < length - 1; i++) {
                if (i % 2 == 0 && nums[i] % 2 != 0) {
                    for (int j = i + 1; j < length; j++) {
                        if (j % 2 != 0 && nums[j] % 2 == 0) {
                            swap(nums,i,j);
                        }
                    }
                } else if (i % 2 != 0 && nums[i] % 2 == 0) {
                    for (int j = i + 1; j < length; j++) {
                        if (j % 2 == 0 && nums[j] % 2 != 0) {
                            swap(nums,i,j);
                        }
                    }
                }
            }
            return nums;
        }

        public void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[j] ^ nums[i];
            nums[i] = nums[i] ^ nums[j];
        }

        public int[] sortArrayByParityII3(int[] nums) {
            int length = nums.length;
            int[] sin = new int[length / 2];
            int[] dou = new int[length / 2];
            int m = 0, n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    dou[n] = nums[i];
                    n++;
                } else {
                    sin[m] = nums[i];
                    m++;
                }
            }
            m = 0;
            n = 0;
            for (int i = 0; i < length; i = i + 2) {
                nums[i] = dou[m];
                nums[i + 1] = sin[n];
                m++;
                n++;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}