//给你一个整数数组 nums ，返回出现最频繁的偶数元素。 
//
// 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [0,1,2,2,4,4,1]
//输出：2
//解释：
//数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
//返回最小的那个，即返回 2 。 
//
// 示例 2： 
//
// 输入：nums = [4,4,4,9,2,4]
//输出：4
//解释：4 是出现最频繁的偶数元素。
// 
//
// 示例 3： 
//
// 输入：nums = [29,47,21,41,13,37,25,7]
//输出：-1
//解释：不存在偶数元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2000 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 哈希表 计数 👍 18 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement{
    public static void main(String[] args){
        Solution solution = new MostFrequentEvenElement().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(num % 2 != 0)continue;
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int res = -1,cnt = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(res == -1 || entry.getValue() > cnt ){
                res = entry.getKey();
                cnt = entry.getValue();
            }else if(entry.getValue() == cnt && entry.getKey() < res){
                res = entry.getKey();
                cnt = entry.getValue();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}