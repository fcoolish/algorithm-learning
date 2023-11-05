//给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// 
//
// 
// 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/ 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 58 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class G5c51o{
    public static void main(String[] args){
        Solution solution = new G5c51o().new Solution();
        int[] arr = {20,100,50,5,10,70,7};

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        for(int num:map.keySet()){
            if(queue.size() == k && map.get(queue.peek()) < map.get(num)){
                queue.poll();
            }
            queue.offer(num);
        }
        int[] ans = new int[k];
        for(int i =0;i < k;i++){
            ans[i] = queue.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}