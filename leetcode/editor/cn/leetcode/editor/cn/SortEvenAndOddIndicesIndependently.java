//给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值： 
//
// 
// 按 非递增 顺序排列 nums 奇数下标 上的所有值。
//
// 
// 举个例子，如果排序前 nums = [4,1,2,3] ，对奇数下标的值排序后变为 [4,3,2,1] 。奇数下标 1 和 3 的值按照非递增顺序重排。 
//
// 
// 
// 按 非递减 顺序排列 nums 偶数下标 上的所有值。
// 
// 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。偶数下标 0 和 2 的值按照非递减顺序重排。 
//
// 
// 
// 
//
// 返回重排 nums 的值之后形成的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,1,2,3]
//输出：[2,3,4,1]
//解释：
//首先，按非递增顺序重排奇数下标（1 和 3）的值。
//所以，nums 从 [4,1,2,3] 变为 [4,3,2,1] 。
//然后，按非递减顺序重排偶数下标（0 和 2）的值。
//所以，nums 从 [4,1,2,3] 变为 [2,3,4,1] 。
//因此，重排之后形成的数组是 [2,3,4,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1]
//输出：[2,1]
//解释：
//由于只有一个奇数下标和一个偶数下标，所以不会发生重排。
//形成的结果数组是 [2,1] ，和初始数组一样。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 排序 
// 👍 6 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEvenAndOddIndicesIndependently{
    public static void main(String[] args){
        Solution solution = new SortEvenAndOddIndicesIndependently().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(i % 2== 0){
                evenList.add(nums[i]);
            }else{
                oddList.add(nums[i]);
            }
        }
        Collections.sort(oddList,Collections.reverseOrder());
        Collections.sort(evenList);
        int length = nums.length;
        int oddIndex = 0,evenIndex = 0;
        for(int i =0;i < length;i++){
            if(i % 2==0){
               nums[i] =  evenList.get(evenIndex);
               evenIndex++;
            }else{
                nums[i] = oddList.get(oddIndex);
                oddIndex++;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}