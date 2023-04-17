//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
//
// Related Topics 位运算 数组 回溯 👍 104 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PowerSetLcci{
    public static void main(String[] args){
        Solution solution = new PowerSetLcci().new Solution();
        int[] nums = {1,2,3};
        solution.subsets(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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