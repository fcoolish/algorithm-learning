//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
//
// Related Topics 数组 回溯 👍 46 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class UUsW3B{
    public static void main(String[] args){
        Solution solution = new UUsW3B().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n,k,new ArrayList<>(),ans,1);
        return ans;
    }

    public void dfs(int n,int k,List<Integer> list,List<List<Integer>> ans,int index){
        if(list.size() + n - index + 1 < k){//剪枝
            return;
        }
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(index);
        dfs(n,k,list,ans,index + 1);
        list.remove(list.size() - 1);
        dfs(n,k,list,ans,index + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}