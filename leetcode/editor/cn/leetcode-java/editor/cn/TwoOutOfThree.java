//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 与这三个数组都不同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数
//组中的元素可以按 任意 顺序排列。
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//输出：[3,2]
//解释：至少在两个数组中出现的所有值为：
//- 3 ，在全部三个数组中都出现过。
//- 2 ，在数组 nums1 和 nums2 中出现过。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//输出：[2,3,1]
//解释：至少在两个数组中出现的所有值为：
//- 2 ，在数组 nums2 和 nums3 中出现过。
//- 3 ，在数组 nums1 和 nums2 中出现过。
//- 1 ，在数组 nums1 和 nums3 中出现过。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//输出：[]
//解释：不存在至少在两个数组中出现的值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length, nums3.length <= 100 
// 1 <= nums1[i], nums2[j], nums3[k] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 14 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree{
    public static void main(String[] args){
        Solution solution = new TwoOutOfThree().new Solution();
        int[] num1 = new int[]{3,1};
        int[] num2 = new int[]{2,3};
        int[] num3 = new int[]{1,2};
        solution.twoOutOfThree(num1,num2,num3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[] record1 = new int[101];
            int[] record2 = new int[101];
            int[] record3 = new int[101];
            for(int num:nums1){
                record1[num] = 1;
            }
            for(int num:nums2){
                record2[num] = 1;
            }
            for(int num:nums3){
                record3[num] = 1;
            }
            List<Integer> res = new ArrayList<>();
            for(int i =0;i < 101;i++){
                if(record1[i] + record2[i] + record3[i] >= 2){
                    res.add(i);
                }
            }
            return res;
        }

        public List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        int[] record = new int[101];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        for(int i =0;i < nums1.length;i++){
            if(i > 0 && nums1[i - 1] == nums1[i]){
                continue;
            }
            record[nums1[i]]++;
        }
        for(int i =0;i < nums2.length;i++){
            if(i > 0 && nums2[i - 1] == nums2[i]){
                continue;
            }
            record[nums2[i]]++;
        }
        for(int i =0;i < nums3.length;i++){
            if(i > 0 && nums3[i - 1] == nums3[i]){
                continue;
            }
            record[nums3[i]]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i =0;i < 101;i++){
            if(record[i] >= 2){
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}