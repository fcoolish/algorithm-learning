//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2153 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray{
    public static void main(String[] args){
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] arr = {2,1,3};
        solution.findKthLargest(arr,1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findKthLargest(int[] nums, int k){
        int n = nums.length;
        quickSort(nums,0,nums.length - 1);
        return nums[n - k];
    }

    public void quickSort(int[] nums,int left,int right){
        if(left >= right)return;
        int base = nums[left];
        int temp = 0;
        int i = left,j = right;
        while (i < j){
            while (i < j && nums[j] >= base){
                j--;
            }
            while (i < j && nums[i] <= base){
                i++;
            }
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        nums[left] = nums[i];
        nums[i] = base;
        quickSort(nums,left,i - 1);
        quickSort(nums,i + 1,right);
    }
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums){
            queue.offer(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}