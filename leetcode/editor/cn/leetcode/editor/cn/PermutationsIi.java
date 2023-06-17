//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1384 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args){
        Solution solution = new PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for(int nu:nums){
                list.add(nu);
            }
            int n = list.size();
            dfs(n,list,0,ans);
            return ans;
        }

        public void dfs(int n,List<Integer> list,int index,List<List<Integer>> ans){
            if(index == n){
                ans.add(new ArrayList<>(list));
                return;
            }
            List<Integer> reList = new ArrayList<>();
            for(int i = index;i < n;i++){
                if(!reList.contains(list.get(i))){
                    Collections.swap(list,i,index);
                    dfs(n,list,index + 1,ans);
                    Collections.swap(list,i,index);
                    reList.add(list.get(i));
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}