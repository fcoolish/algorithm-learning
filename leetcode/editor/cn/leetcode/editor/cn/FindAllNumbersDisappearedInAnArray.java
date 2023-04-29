//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 973 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args){
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        int[] arr = {4,3,2,7,8,2,3,1};
        solution.findDisappearedNumbers(arr);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums){
        int n = nums.length;
        for (int num:nums){
            int x = (num - 1) % n;
            nums[x] +=n;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i < n;i++){
            if(nums[i] <= n){
                ans.add(i + 1);
            }
        }
        return ans;
    }
    public List<Integer> findDisappearedNumbers2(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for(int i= 0;i < nums.length;i++){
            if(nums[i] != i + 1 && (nums[nums[i] - 1] != nums[i])){
                int tempA = nums[i];
                int tempB = nums[nums[i] - 1];
                nums[i] = tempB;
                nums[tempA - 1] = tempA;
                i--;
            }
        }
        for(int i= 0;i < nums.length;i++){
            if(nums[i] != i + 1){
                ans.add(i + 1);
            }
        }
        return ans;
    }
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] count  = new int[n + 1];
        for(int num:nums){
            count[num]++;
        }
        for(int i =0;i < n + 1;i++){
            if(i >0 && count[i] <=0){
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}