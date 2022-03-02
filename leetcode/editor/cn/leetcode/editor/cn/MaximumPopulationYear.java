//给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。 
//
// 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内
//。注意，人不应当计入他们死亡当年的人口中。 
//
// 返回 人口最多 且 最早 的年份。 
//
// 
//
// 示例 1： 
//
// 输入：logs = [[1993,1999],[2000,2010]]
//输出：1993
//解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
// 
//
// 示例 2： 
//
// 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
//输出：1960
//解释： 
//人口最多为 2 ，分别出现在 1960 和 1970 。
//其中最早年份是 1960 。 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 100 
// 1950 <= birthi < deathi <= 2050 
// 
// Related Topics 数组 计数 
// 👍 38 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaximumPopulationYear {
    public static void main(String[] args) {
        Solution solution = new MaximumPopulationYear().new Solution();
        int[][] num = new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}};
        solution.maximumPopulation(num);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumPopulation2(int[][] logs) {
            int length = logs.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                int start = logs[i][0];
                int end = logs[i][1];
                for (int j = start; j < end; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
            int max = 0, year = 2051;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= max && entry.getKey() < year) {
                    max = entry.getValue();
                    year = entry.getKey();
                }else if(entry.getValue() > max){
                    max = entry.getValue();
                    year = entry.getKey();
                }
            }
            return year;
        }

        public int maximumPopulation(int[][] logs) {
            int length = logs.length;
            int[] num = new int[101];
            for (int i = 0; i < length; i++) {
                int start = logs[i][0];
                int end = logs[i][1];
                for (int j = start; j < end; j++) {
                    num[j - 1950]++;
                }
            }
            int max = 0, year = 2051;
            for (int i =0;i < 101;i++) {
                if(num[i] > max){
                    max = num[i];
                    year = i + 1950;
                }
            }
            return year;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}