//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 762 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysIi{
    public static void main(String[] args){
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        solution.intersect(nums1,nums2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = 0,l2 = 0;
        int len = nums1.length > nums2.length ? nums2.length:nums1.length;
        int[] res = new int[len];
        int index = 0;
        while (l1 < nums1.length && l2 < nums2.length){
            if(nums1[l1] == nums2[l2]){
                res[index++] = nums1[l1];
                l1++;
                l2++;
            }else if(nums1[l1] < nums2[l2]){
                l1++;
            }else{
                l2++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        List<Integer> res = new ArrayList<>();
        for(int i =0;i < nums1.length;i++){
            count[nums1[i]]++;
        }
        for(int i =0;i < nums2.length;i++){
            if (count[nums2[i]] == 0)continue;
            res.add(nums2[i]);
            count[nums2[i]]--;
        }
        int len = res.size();
        int[] ans = new int[len];
        for(int i = 0;i < len;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}