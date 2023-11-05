//给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入：deck = [1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 
//输入：deck = [1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10⁴ 
// 0 <= deck[i] < 10⁴ 
// 
// Related Topics 数组 哈希表 数学 计数 数论 👍 278 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards{
    public static void main(String[] args){
        Solution solution = new XOfAKindInADeckOfCards().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:deck){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int gcd = -1;
        for(int num:map.values()){
            if(gcd == -1){
                gcd = num;
            }else{
                gcd = gcd(gcd,num);
            }
        }
        return gcd >= 2;
    }

    private int gcd(int a,int b){
        return b == 0? a:gcd(b,a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}