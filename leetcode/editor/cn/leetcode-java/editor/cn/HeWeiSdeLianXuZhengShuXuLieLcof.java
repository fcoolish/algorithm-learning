//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//
// Related Topics 数学 双指针 枚举 👍 540 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args){
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        solution.findContinuousSequence(9);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence1(int target) {
        List<List<Integer>> list = new ArrayList<>();
        int limit = (target + 1)/2;
        for(int i = 1;i <= limit;i++){
            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            for(int j = i;j <= limit;j++){
                sum += j;
                temp.add(j);
                if(sum > target){
                    break;
                }else if(sum == target){
                    list.add(temp);
                    break;
                }
            }
        }
        int[][] ans = new int[list.size()][];
        for(int i =0;i < list.size();i++){
            int[] arr = new int[list.get(i).size()];
            for(int j = 0;j < list.get(i).size();j++){
                arr[j] = list.get(i).get(j);
            }
            ans[i] = arr;
        }
        return ans;
    }

   public int[][] findContinuousSequence(int target){
        List<int[]> ans = new ArrayList<>();
        for(int l = 1,r = 2;l < r;){
            int sum = (r - l + 1) * (l + r)/2;
            if(sum == target){
                int[] res = new int[r - l + 1];
                for(int i = l;i <= r;i++){
                    res[i - l] = i;
                }
                ans.add(res);
                l++;
            }else if(sum > target){
                l++;
            }else{
                r++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
   }

    }
//leetcode submit region end(Prohibit modification and deletion)

}