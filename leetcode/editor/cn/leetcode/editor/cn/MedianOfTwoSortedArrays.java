//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6498 👎 0

package leetcode.editor.cn;
public class MedianOfTwoSortedArrays{
    public static void main(String[] args){
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] arr = {};
        int[] arr2 = {1,3};
        solution.findMedianSortedArrays(arr,arr2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //合并数组
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int l1 = nums1.length,l2 = nums2.length;
        int index = 0;
        int val = l1 + l2;
        int[] newArr = new int[val/2 + 2];
        int m = 0,n = 0;
        while (m < l1 && n < l2 && index < (val/2 + 1)){
            if(nums1[m] < nums2[n]){
                newArr[index++] = nums1[m++];
            }else{
                newArr[index++] = nums2[n++];
            }
        }
        while (m < l1 && index < (val/2 + 1)){
            newArr[index++] = nums1[m++];
        }
        while (n < l2 && index < (val/2 + 1)){
            newArr[index++] = nums2[n++];
        }
        if(val == 0 || val % 2 != 0){
            return newArr[val/2];
        }
        return (newArr[val/2] + newArr[val/2 - 1])/2.0;
    }

    //todo 双指针版未完成
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length,l2 = nums2.length;
        int index = 0;
        int val = l1 + l2;
        int m = 0,n = 0;
        while (m < l1 && n < l2){
            if(nums1[m] < nums2[n]){
                m++;
            }else{
                n++;
            }
            index++;
        }
        if(index > val/2){
            if(val % 2  != 0){
                return Math.min(nums2[n],nums1[m]);
            }else{
                return (nums2[n] + nums1[m])/2;
            }
        }else if(index < val){
           return m == l1 ? nums2[n + val - index] :nums1[m + val - index];
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}