//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// Related Topics 数组 双指针 排序 
// 👍 241 👎 0

package leetcode.editor.cn;

public class SortArrayByParity{
    public static void main(String[] args){
        Solution solution = new SortArrayByParity().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int[] sortArrayByParity(int[] nums) {
            int length = nums.length;
            int l = 0,r = length - 1;
            while (l < r){
                while (l < r && nums[l] % 2 == 0){
                    l++;
                }
                while (l < r && nums[r] % 2 == 1){
                    r--;
                }
                if(l < r){
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                }
            }
            return nums;
        }

        public int[] sortArrayByParity2(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int left = 0,right = length - 1;
        for(int num:nums){
            if(num % 2 ==0){
                res[left] = num;
                left++;
            }else{
                res[right] = num;
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}