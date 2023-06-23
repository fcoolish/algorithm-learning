//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 
//
// 
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
//
// Related Topics 数组 回溯 👍 53 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSjJUc{
    public static void main(String[] args){
        Solution solution = new FourSjJUc().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int tar = 0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int n = candidates.length;
            tar = target;
            Arrays.sort(candidates);
            dfs(n, candidates, 0, new ArrayList<>(), res, 0);
            return res;
        }

        private void dfs(int n, int[] can, int sum, List<Integer> list, List<List<Integer>> ans, int index) {
            if (sum == tar) {//边界条件
                ans.add(new ArrayList<>(list));
                return;
            }
            if (sum > tar || n == index) return;
            dfs(n, can, sum, list, ans, getNext(can,index));
            list.add(can[index]);
            dfs(n, can, sum + can[index], list, ans, index + 1);
            list.remove(Integer.valueOf(can[index]));
        }

        private int getNext(int[] can,int index){
            for(int i = index + 1;i < can.length;i++){
                if(can[i] != can[index]){
                    return i;
                }
            }
            return can.length;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}