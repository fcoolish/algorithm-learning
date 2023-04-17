//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2010 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args){
        Solution solution = new Subsets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            int mask = 1 << n;
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for(int i =0;i < mask;i++){
                for(int j =0;j < n;j++){
                    if(((i >> j) & 1) == 1){
                        list.add(nums[j]);
                    }
                }
                ans.add(new ArrayList<>(list));
                list.clear();
            }
            return ans;
        }

        public List<List<Integer>> subsets1(int[] nums) {
            int n = nums.length;
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
            dfs(n,nums,list,ans,index + 1);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}