//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 504 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArrays{
    public static void main(String[] args){
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {1,2,2,1};
        int[] num2 = {2,2};
        solution.intersection(nums1,num2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] intersection(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1 + n2 - 1];
        int l1 = 0,l2 = 0,index = 0;
        while (l1 < n1 && l2 < n2){
            if(nums1[l1] == nums2[l2] && (index == 0 || nums1[l1] != res[index - 1])){
                res[index++] = nums1[l1];
                l1++;
                l2++;
            }else if(nums1[l1] > nums2[l2]){
                l2++;
            }else{
                l1++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] compare = new int[1001];
        List<Integer> res = new LinkedList<>();
        for(int num:nums1){
            compare[num]++;
        }
        for(int num:nums2){
            if(compare[num] > 0 && !res.contains(num)){
                res.add(num);
            }
        }
        int length = res.size();
        int[] arr = new int[length];
        for(int i =0;i < length;i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}