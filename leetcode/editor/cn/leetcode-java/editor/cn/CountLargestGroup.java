//给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。 
//
// 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。 
//
// 
//
// 示例 1： 
//
// 输入：n = 13
//输出：4
//解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
//[1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：2
//解释：总共有 2 个大小为 1 的组 [1]，[2]。
// 
//
// 示例 3： 
//
// 输入：n = 15
//输出：6
// 
//
// 示例 4： 
//
// 输入：n = 24
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^4 
// 
// Related Topics 哈希表 数学 👍 35 👎 0

package leetcode.editor.cn;

import java.util.*;

public class CountLargestGroup{
    public static void main(String[] args){
        Solution solution = new CountLargestGroup().new Solution();
        solution.countLargestGroup(13);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1;i <= n;i++){
            int cnt = calCount(i);
            map.put(cnt,map.getOrDefault(cnt,0)  +1);
        }
        int max = 0,size = 0;
        for(Integer value: map.values()){
            if (value > max){
                max = value;
                size = 1;
            }else if(value == max){
                size++;
            }
        }
        return size;
    }

    private int calCount(int num){
        int res = 0;
        while (num != 0){
            res += num % 10;
            num /= 10;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}