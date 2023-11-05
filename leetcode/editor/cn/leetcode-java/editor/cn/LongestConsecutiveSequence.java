//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1630 👎 0

package leetcode.editor.cn;

import java.util.*;

public class LongestConsecutiveSequence{
    public static void main(String[] args){
        Solution solution = new LongestConsecutiveSequence().new Solution();
        int[] arr = {1,2,0,1};
        solution.longestConsecutive(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums){
        if(nums.length <= 1)return nums.length;
        Arrays.sort(nums);
        int max = 1;
        int cnt = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i - 1] == nums[i])continue;
            if(nums[i - 1] + 1 == nums[i]){
                cnt++;
            }else{
                max = Math.max(max,cnt);
                cnt = 1;
            }
        }
        max = Math.max(max,cnt);
        return max;
    }

    public int longestConsecutive1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            if(!list.contains(num)){
                list.add(num);
            }
        }
        int max = 0;
        for(int num:list){
            if(!list.contains(num - 1)){
                int curNum = num;
                int curStr = 1;
                while (list.contains(curNum + 1)){
                    curNum++;
                    curStr++;
                }
                max = Math.max(curStr,max);
                if (max >= n/2){
                    return max;
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}