//给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。 
//
// 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况： 
//
// 
// 名次第 1 的运动员获金牌 "Gold Medal" 。 
// 名次第 2 的运动员获银牌 "Silver Medal" 。 
// 名次第 3 的运动员获铜牌 "Bronze Medal" 。 
// 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。 
// 
//
// 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：score = [5,4,3,2,1]
//输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。 
//
// 示例 2： 
//
// 
//输入：score = [10,3,8,9,4]
//输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
// 
//
// 
//
// 提示： 
//
// 
// n == score.length 
// 1 <= n <= 104 
// 0 <= score[i] <= 106 
// score 中的所有值 互不相同 
// 
// Related Topics 数组 排序 堆（优先队列） 
// 👍 178 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks{
    public static void main(String[] args){
        Solution solution = new RelativeRanks().new Solution();
        int[] num = new int[]{5,4,3,2,1};
        solution.findRelativeRanks(num);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public String[] findRelativeRanks(int[] score) {
            int n = score.length;
            int[][] record = new int[n][2];
            String[] desc = new String[]{"Gold Medal","Silver Medal","Bronze Medal"};
            String[] res = new String[n];
            for(int i=0;i < n;i++){
                record[i][0] = score[i];
                record[i][1] = i;
            }
            Arrays.sort(record,(a,b)->b[0] - a[0]);
            for(int i=0;i < n;i++){
                if(i >= 3){
                    res[record[i][1]] = String.valueOf(i + 1);
                }else{
                    res[record[i][1]] = desc[i];
                }
            }
            return res;
        }


        public String[] findRelativeRanks2(int[] score) {
        int[] record = score.clone();
        Arrays.sort(score);
        int n = score.length;
        String[] res = new String[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=n - 1;i >= 0;i--){
            map.put(score[i],n -i);
        }
        for(int i=0;i < n;i++){
            if(map.get(record[i]) == 1){
                res[i] = "Gold Medal";
            }else if(map.get(record[i]) == 2){
                res[i] = "Silver Medal";
            }else if(map.get(record[i]) == 3){
                res[i] = "Bronze Medal";
            }else{
                res[i] = String.valueOf(map.get(record[i]));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}