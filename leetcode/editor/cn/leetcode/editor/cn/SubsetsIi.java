//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1120 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi{
    public static void main(String[] args){
        Solution solution = new SubsetsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            dfs(n,nums,new ArrayList<>(),ans,0);
            return ans;
        }

        public void dfs(int n,int[] nums,List<Integer> list,List<List<Integer>> ans,int index){
            if(index == n){
                ans.add(new ArrayList<>(list));
                return;
            }
            list.add(nums[index]);
            dfs(n,nums,list,ans,index + 1);
            list.remove(new Integer(nums[index]));//remove重载
            dfs(n,nums,list,ans,getIndex(nums,index));
        }

        private int getIndex(int[] nums,int index){
            int n = nums.length;
            for(int i = index;i <nums.length;i++){
                if(nums[i] != nums[index]){
                    return i;
                }
            }
            return n;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}