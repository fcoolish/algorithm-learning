//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//>输入：`cards = [1,2,8,9], cnt = 3`
//>
//>输出：`18`
//>
//>解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//>输入：`cards = [3,3,1], cnt = 1`
//>
//>输出：`0`
//>
//>解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
//
// Related Topics 贪心 数组 排序 👍 35 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class UOAnQW{
    public static void main(String[] args){
        Solution solution = new UOAnQW().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length;
        Arrays.sort(cards);
        int sum = 0;
        int even = Integer.MAX_VALUE,odd = Integer.MAX_VALUE;
        int max = 0;
        for(int i = n - 1;i >= n - cnt;i--){
            sum += cards[i];
            if(cards[i] % 2 != 0){
                odd = cards[i];
            }else{
                even = cards[i];
            }
        }
        if(sum % 2 == 0){
            return sum;
        }
        for(int i = n - cnt - 1;i >=0;i--){
            max = Math.max(max,sum + cards[i] - (cards[i] % 2 != 0 ? even : odd));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}