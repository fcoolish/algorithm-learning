//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
//
// Related Topics 数组 回溯 👍 50 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VvJkup{
    public static void main(String[] args){
        Solution solution = new VvJkup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> outpiut = new ArrayList<>();
        for(int num:nums){
            outpiut.add(num);
        }
        int n = nums.length;
        backtrack(n,outpiut,ans,0);
        return ans;
    }

    public void backtrack(int n,List<Integer> output,List<List<Integer>> ans,int index){
        if(index == n){
            ans.add(new ArrayList<>(output));
        }
        for(int i = index;i < n;i++){
            Collections.swap(output,index,i);
            backtrack(n,output,ans,index + 1);
            Collections.swap(output,index,i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}