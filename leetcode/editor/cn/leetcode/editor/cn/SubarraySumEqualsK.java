//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 1909 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK{
    public static void main(String[] args){
        Solution solution = new SubarraySumEqualsK().new Solution();
        int[] arr = {1,-1,0};
        solution.subarraySum(arr,0);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int subarraySum(int[] nums, int k){
        int pre = 0;
        int n = nums.length;
        int ans  = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i < n;i++){
            pre += nums[i];
            ans += map.getOrDefault(pre - k,0);
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return ans;
    }


    //性能低
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        for(int i =0;i < n;i++){
            sum = 0;
            for(int j = i;j< n;j++){
                sum += nums[j];
                if(sum == k){
                    ans++;
                }
            }
        }
        return ans;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}