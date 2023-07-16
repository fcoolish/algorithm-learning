//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 862 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

public class SortAnArray{
    public static void main(String[] args){
        Solution solution = new SortAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        if(set.size() == 1)return nums;
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    private  void quickSort(int[] nums,int low,int high){
        if(low >= high)return;
        int i,j,temp,base;
        i = low;
        j = high;
        base = nums[low];
        while (i < j){
            while (i < j && nums[j] >= base){
                j--;
            }
            while (i < j && nums[i] <= base){
                i++;
            }
            if(i < j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[i];
        nums[i] = base;
        quickSort(nums,low,i - 1);
        quickSort(nums,i + 1,high);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}