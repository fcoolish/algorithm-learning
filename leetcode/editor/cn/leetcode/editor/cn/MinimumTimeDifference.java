//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// Related Topics 数组 数学 字符串 排序 👍 240 👎 0

package leetcode.editor.cn;

import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference{
    public static void main(String[] args){
        Solution solution = new MinimumTimeDifference().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findMinDifference(List<String> timePoints) {
            int n = timePoints.size();
            if(n > 1440)return 0;
            int ans = Integer.MAX_VALUE;
            Collections.sort(timePoints);
            for(int i = 0;i < n - 1;i++){
                String[] a1 = timePoints.get(i).split(":");
                String[] a2 = timePoints.get(i + 1).split(":");
                int diff =  Integer.parseInt(a1[0]) * 60 + Integer.parseInt(a1[1]) - Integer.parseInt(a2[0]) * 60 - Integer.parseInt(a2[1]);
                ans = Math.min(ans,Math.abs(diff));
                if(i == 0){
                    String[] an = timePoints.get(n - 1).split(":");
                    int diffn =  1440 + Integer.parseInt(a1[0]) * 60 + Integer.parseInt(a1[1]) - Integer.parseInt(an[0]) * 60 - Integer.parseInt(an[1]);
                    ans = Math.min(ans,diffn);
                }
            }
            return ans;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}