//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。 
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
// 
//
// 示例 2： 
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
// 
//
// 示例 3： 
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
// 
//
// 示例 4： 
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1.length == s2.length 
// s1 和 s2 仅由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 96 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwapCanMakeStringsEqual{
    public static void main(String[] args){
        Solution solution = new CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        solution.areAlmostEqual("bank","kanb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if(s1.equals(s2))return true;
            List<Integer> list = new ArrayList<>();
            for(int i =0;i < s1.length();i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    list.add(i);
                    if(list.size() > 2){
                        return false;
                    }
                }
            }
            if(list.size() == 0){
                return true;
            }
            if(list.size()!= 2){
                return false;
            }
            return s1.charAt(list.get(0)) == s2.charAt(list.get(1)) && s1.charAt(list.get(1)) == s2.charAt(list.get(0));
        }

        public boolean areAlmostEqual2(String s1, String s2) {
        if(s1.equals(s2))return true;
        int len = s2.length();
        for(int i =0;i < len - 1;i++){
            for(int j = 1;j<len;j++){
                StringBuilder str = new StringBuilder(s2);
                str.setCharAt(i,s2.charAt(j));
                str.setCharAt(j,s2.charAt(i));
                if(str.toString().equals(s1)){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}