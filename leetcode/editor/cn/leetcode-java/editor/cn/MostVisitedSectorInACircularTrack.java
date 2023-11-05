//给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全
//程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 
//rounds[0] 开始，到 rounds[1] 结束。 
//
// 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。 
//
// 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, rounds = [1,3,1,2]
//输出：[1,2]
//解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
//1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
//其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。 
//
// 示例 2： 
//
// 输入：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
//输出：[2]
// 
//
// 示例 3： 
//
// 输入：n = 7, rounds = [1,3,5,7]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= m <= 100 
// rounds.length == m + 1 
// 1 <= rounds[i] <= n 
// rounds[i] != rounds[i + 1] ，其中 0 <= i < m 
// 
// Related Topics 数组 模拟 👍 33 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostVisitedSectorInACircularTrack{
    public static void main(String[] args){
        Solution solution = new MostVisitedSectorInACircularTrack().new Solution();
        int[] nums = new int[]{2,1,2,1,2,1,2,1,2};
        solution.mostVisited(4,nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<Integer> mostVisited(int n, int[] rounds) {
            int len = rounds.length;
            int start = rounds[0];
            int end = rounds[0] <= rounds[len- 1] ? rounds[len - 1] : (rounds[len - 1] + n);
            List<Integer> res = new ArrayList<>();
            for(int i = start;i <= end;i++){
                int index = i > n ? i % n:i;
                res.add(index);
            }
            Collections.sort(res);
            return res;
        }

        public List<Integer> mostVisited2(int n, int[] rounds) {
        int[] num = new int[101];
        int len = rounds.length;
        for(int i = 0;i < len - 1;i++){
             int end = rounds[i + 1] < rounds[i] ? rounds[i + 1] + n:rounds[i + 1];
            for(int j = rounds[i];j < end;j++){
                int index = j > n ? j % n:j;
                num[index]++;
            }
        }
        num[rounds[len - 1]]++;
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for(int i =0;i < 101;i++){
            if(num[i] > max){
                res.clear();
                res.add(i);
                max = num[i];
            }else if(num[i] ==max){
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}